package com.wipro.holmes.uhg.enb.nvs.models;

import lombok.Getter;

@Getter
public enum ValidateStrategy {
	GSF_1_3("GSF_1.3"), GSF_1_5("GSF_1.5");

	private final String strategy;

	private ValidateStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String toString() {
		return strategy;
	}
}
