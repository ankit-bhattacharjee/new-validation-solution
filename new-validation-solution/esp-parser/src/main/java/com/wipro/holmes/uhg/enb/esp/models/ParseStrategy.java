package com.wipro.holmes.uhg.enb.esp.models;

import lombok.Getter;

@Getter
public enum ParseStrategy {
	GSF_1_3(Constants.GSF_1_3), GSF_1_5(Constants.GSF_1_5), HIPPA_834(Constants.HIPPA_834);

	private final String strategy;

	private ParseStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String toString() {
		return strategy;
	}

}
