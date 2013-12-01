package org.simplebatchframework.example.dao;

import org.simplebatchframework.core.annotation.After;
import org.simplebatchframework.core.annotation.Before;
import org.simplebatchframework.core.dao.AbstractDao;

@Before({"startLogAdvice", "performanceLogAdvice", "parameterDebugLogAdvice"})
@After({"resultDebugLogAdvice", "performanceLogAdvice", "endLogAdvice"})
public class AbstractExampleDao extends AbstractDao {

}
