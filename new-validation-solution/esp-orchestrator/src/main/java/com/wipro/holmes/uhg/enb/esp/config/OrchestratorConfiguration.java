package com.wipro.holmes.uhg.enb.esp.config;

import java.util.Collections;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.Data;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConfigurationProperties("orchestrator")
@EnableSwagger2
@Data
public class OrchestratorConfiguration {

	private String parserUri;
	private String persistorUri;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.wipro.holmes.uhg.enb.esp.controllers"))
				.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfo("ESP Orchestrator", "Provides endpoints to upload, parse/validate & access data",
						"0.0.1", "TOS Info", new Contact("Wipro Holmes", "www.holmes.wipro.com", "www.wipro.com"),
						"License Info", "API license URL", Collections.emptyList()));
	}

}
