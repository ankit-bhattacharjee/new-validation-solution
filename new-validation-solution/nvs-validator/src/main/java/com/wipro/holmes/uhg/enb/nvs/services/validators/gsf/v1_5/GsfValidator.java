package com.wipro.holmes.uhg.enb.nvs.services.validators.gsf.v1_5;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.validators.Validator;

@Service("GSF_1.5")
public class GsfValidator implements Validator<Record> {

	private KieServices kieServices;
	private KieContainer kContainer;

	public GsfValidator() {
		kieServices = KieServices.Factory.get();
		kContainer = kieServices.getKieClasspathContainer();
	}

	@Override
	public void validate(Record record) {
		StatelessKieSession kSession = kContainer.getKieBase().newStatelessKieSession();
		record.getFields().keySet().forEach(key -> kSession.execute(record.getFields().get(key)));
	}

}
