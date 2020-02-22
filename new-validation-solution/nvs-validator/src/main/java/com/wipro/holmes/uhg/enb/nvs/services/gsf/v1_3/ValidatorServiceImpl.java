package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.exceptions.ValidatorException;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import static com.wipro.holmes.uhg.enb.nvs.models.Constants.*;
import com.wipro.holmes.uhg.enb.nvs.services.ValidatorService;

@Service(GSF_1_3 + SERVICE)
public class ValidatorServiceImpl implements ValidatorService<Record> {

	private KieServices kieServices;
	private KieContainer kContainer;
	private final KafkaTemplate<String, Record> template;
	private static final String CONSUMER_TOPIC_NAME = "producers-parser-gsf-1-3";
	private static final String PRODUCER_TOPIC_NAME = "producers-validator-gsf-1-3";

	public ValidatorServiceImpl(KafkaTemplate<String, Record> template) {
		kieServices = KieServices.Factory.get();
		kContainer = kieServices.getKieClasspathContainer();
		this.template = template;
	}

	@Override
	@KafkaListener(topics = CONSUMER_TOPIC_NAME, containerFactory = "kafkaListenerContainerFactory")
	public void validateAndPublish(Record record) throws ValidatorException {
		StatelessKieSession kSession = kContainer.getKieBase().newStatelessKieSession();
		record.getFields().keySet().forEach(key -> kSession.execute(record.getFields().get(key)));
		template.send(PRODUCER_TOPIC_NAME, record);
	}

}
