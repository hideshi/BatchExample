package org.simplebatchframework.example.logic;

import org.simplebatchframework.core.annotation.After;
import org.simplebatchframework.core.annotation.Before;
import org.simplebatchframework.core.logic.AbstractLogic;

@Before({"startLogAdvice", "performanceLogAdvice", "parameterDebugLogAdvice"})
@After({"resultDebugLogAdvice", "performanceLogAdvice", "endLogAdvice"})
public abstract class AbstractExampleLogic extends AbstractLogic {

}
