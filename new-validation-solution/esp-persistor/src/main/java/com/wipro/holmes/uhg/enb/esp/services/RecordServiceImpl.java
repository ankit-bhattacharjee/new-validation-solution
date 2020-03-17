package com.wipro.holmes.uhg.enb.esp.services;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.wipro.holmes.uhg.enb.esp.config.PersistorConfiguration;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.repositories.FileMetaRepository;
import com.wipro.holmes.uhg.enb.esp.repositories.RecordRepository;

@Service
public class RecordServiceImpl implements RecordService<Record> {

	private final FileMetaRepository metaRepository;
	private final RecordRepository recordRepository;
	private final BlockingQueue<Record> queue;
	private final Map<String, Pair<Integer, AtomicInteger>> records;
	private static final String CONSUMER_TOPIC_NAME = "producers-validator-gsf-1-3";

	public RecordServiceImpl(PersistorConfiguration configuration, FileMetaRepository metaRepository,
			RecordRepository recordRepository) {
		this.metaRepository = metaRepository;
		this.recordRepository = recordRepository;
		this.queue = new LinkedBlockingQueue<>(configuration.getBatchSize());
		this.records = new ConcurrentHashMap<>();
	}

	@Override
	@Async("process-executor")
	@KafkaListener(topics = CONSUMER_TOPIC_NAME, containerFactory = "kafkaListenerContainerFactory")
	public CompletableFuture<Void> saveAndNotify(Record record) throws InterruptedException {
//		Thread.sleep(100);
		Pair<Integer, AtomicInteger> pair = records.get(record.getFileId());
		if (pair == null) {
			pair = Pair.of(metaRepository.findBy_id(record.getFileId()).getRecords(), new AtomicInteger(0));
			records.putIfAbsent(record.getFileId(), pair);
		}
		if (queue.remainingCapacity() == 0)
			synchronized (this) {
				flush();
			}
		;
		queue.offer(record);
		// Wake any getter threads
		if (pair.getFirst() == pair.getSecond().incrementAndGet()) {
			synchronized (pair) {
				pair.notify();
			}
		}
		return CompletableFuture.completedFuture(null);
	}

	@Override
	public Page<Record> waitAndFindAll(String fileId, Pageable page) throws InterruptedException {
//		System.out.println(metaRepository.findById(fileId).get().getRecords());
//		System.out.println(recordRepository.countByFileId(fileId));
		synchronized (this) {
			flush();
		}
		// DB verification
		if (metaRepository.findById(fileId).get().getRecords() != recordRepository.countByFileId(fileId)) {
			Pair<Integer, AtomicInteger> pair = records.get(fileId);
			// if pair is null throw exception
			// System.out.println(pair.getFirst() + " " + pair.getSecond().get());
			if (pair.getFirst() != pair.getSecond().get())
				synchronized (pair) {
					pair.wait();
				}
			records.remove(fileId);
		}
		return recordRepository.findByFileId(fileId, page);
	}

	public void flush() {
		recordRepository.saveAll(queue);
		queue.clear();
	}

}
