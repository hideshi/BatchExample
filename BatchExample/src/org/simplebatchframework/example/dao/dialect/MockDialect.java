package org.simplebatchframework.example.dao.dialect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import org.simplebatchframework.core.bean.IBean;
import org.simplebatchframework.core.dao.IDao;
import org.simplebatchframework.core.dao.dialect.AbstractDialect;

public class MockDialect extends AbstractDialect {
	
	@Override
	public Connection createConnection() {
		return null;
	}
	
	@Override
	public <T extends IBean, T2 extends IDao> ResultSet executeQuery(T bean, Class<T2> daoClass) {
		return null;
	}
	
	@Override
	public <T extends IBean, T2 extends IDao> int executeUpdate(T bean, Class<T2> daoClass) {
		return 0;
	}
	
	@Override
	public <T extends IBean, T2 extends IDao> List<T> resultSetToBean(ResultSet rs, Class<T> clazz, Class<T2> daoClass) {
		return null;
	}
}
