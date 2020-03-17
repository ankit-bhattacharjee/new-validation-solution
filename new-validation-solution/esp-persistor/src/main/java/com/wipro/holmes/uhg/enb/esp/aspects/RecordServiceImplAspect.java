//package com.wipro.holmes.uhg.enb.esp.aspects;
//
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//import com.wipro.holmes.uhg.enb.esp.models.Record;
//import com.wipro.holmes.uhg.enb.esp.services.RecordService;
//
//@Aspect
//@Component
//public class RecordServiceImplAspect {
//
//	private final RecordService<Record> service;
//
//	public RecordServiceImplAspect(RecordService<Record> service) {
//		this.service = service;
//	}
//
//	@Before("execution(* com.wipro.holmes.uhg.enb.esp.repositories.RecordRepository.findByFileId(..))")
//	public void beforeFindByFileId() {
//		service.flush();
//	}
//
//}
