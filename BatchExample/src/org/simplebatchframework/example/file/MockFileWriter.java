package org.simplebatchframework.example.file;

import java.util.List;

import org.simplebatchframework.core.bean.IBean;
import org.simplebatchframework.core.file.IFileWriter;

public class MockFileWriter implements IFileWriter {

	@Override
	public <T extends IBean, T2 extends IBean> void write(List<T> beans, String path, String fileName, String encodeType, boolean makeDirectory, Class<T2> beanClass) {
	}
}
