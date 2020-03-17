package com.wipro.holmes.uhg.enb.esp.services;

import static org.springframework.web.reactive.function.client.WebClient.builder;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import com.wipro.holmes.uhg.enb.esp.config.ParserConfiguration;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractFileService {
	protected final ParserConfiguration configuration;

	protected WebClient client(String uri) {
		return builder()
				.exchangeStrategies(ExchangeStrategies.builder()
						.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(-1)).build())
				.baseUrl(uri).build();
	}

}
