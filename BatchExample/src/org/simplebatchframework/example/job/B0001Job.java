package org.simplebatchframework.example.job;

import org.simplebatchframework.core.annotation.Inject;
import org.simplebatchframework.core.annotation.Transactional;
import org.simplebatchframework.core.logic.ILogic;

@Transactional
public class B0001Job extends AbstractExampleJob {
	
	@Inject
	private ILogic b0001Logic;

	@Override
	protected void executeJob() {
		b0001Logic.execute(null);
	}
}
