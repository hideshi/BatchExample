package org.simplebatchframework.example.file;

import java.util.List;

import org.simplebatchframework.core.bean.IBean;
import org.simplebatchframework.core.file.IFileReader;

public class MockFileReader implements IFileReader {

	@Override
	public <T extends IBean> List<T> read(String path, String fileName, String encodeType, Class<T> beanClass) {
		return null;
	}
}
