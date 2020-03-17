package com.wipro.holmes.uhg.enb.esp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication()
public class EspPersistorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EspPersistorApplication.class, args);
	}

}
