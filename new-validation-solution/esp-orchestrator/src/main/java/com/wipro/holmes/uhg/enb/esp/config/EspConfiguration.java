package com.wipro.holmes.uhg.enb.esp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@ConfigurationProperties("esp")
@Data
public class EspConfiguration {

	private String uploadDirectory;

}
