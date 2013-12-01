package org.simplebatchframework.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.simplebatchframework.core.bean.IBean;
import org.simplebatchframework.core.bean.IResult;
import org.simplebatchframework.core.bean.Result;
import org.simplebatchframework.example.bean.EmployeeBean;

public class EmployeeSelectMockDao extends EmployeeSelectDao {

	@Override
	protected <T extends IBean> IResult executeDao(T bean) {
		Result<IBean> result = new Result<IBean>();
		List<IBean> list = new ArrayList<IBean>();

		EmployeeBean bean2 = new EmployeeBean();
		bean2.setId(1);
		bean2.setLastName("小林");
		bean2.setSalary(200000);
		list.add(bean2);

		EmployeeBean bean3 = new EmployeeBean();
		bean3.setId(2);
		bean3.setFirstName("新太郎");
		bean3.setLastName("池田");
		bean3.setBossLastName("吉田");
		list.add(bean3);

		result.setBeanList(list);
		return result;
	}
}
