package org.simplebatchframework.example.job;

import org.simplebatchframework.core.annotation.After;
import org.simplebatchframework.core.annotation.Before;
import org.simplebatchframework.core.job.AbstractJob;

@Before({"startLogAdvice", "performanceLogAdvice"})
@After({"performanceLogAdvice", "endLogAdvice"})
public abstract class AbstractExampleJob extends AbstractJob {

}
