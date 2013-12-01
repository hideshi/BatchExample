package org.simplebatchframework.example.logic;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.simplebatchframework.core.CharacterCode;
import org.simplebatchframework.core.annotation.Inject;
import org.simplebatchframework.core.bean.IBean;
import org.simplebatchframework.core.bean.IResult;
import org.simplebatchframework.core.bean.Result;
import org.simplebatchframework.core.dao.IDao;
import org.simplebatchframework.core.file.IFileReader;
import org.simplebatchframework.core.file.IFileWriter;
import org.simplebatchframework.example.bean.CompanyBean;
import org.simplebatchframework.example.bean.EmployeeBean;

public class B0001Logic extends AbstractExampleLogic {

	@Inject
	private IDao employeeSelectDao;

	@Inject
	private IDao companyInsertDao;

	@Inject
	private IFileReader cSVFileReader;
	
	@Inject
	private IFileWriter cSVFileWriter;

	@SuppressWarnings("unchecked")
	@Override
	protected <T extends IBean> IResult executeLogic(T bean) {
		EmployeeBean bean2 = new EmployeeBean();
		bean2.setId(2);
		Result<T> result = (Result<T>) employeeSelectDao.execute(bean2);
		List<T> list  = result.getBeanList();

		String rootFilePath = context.getConfiguration().getProperty("rootFilePath");

		String employeeCSVFileName = context.getConfiguration().getProperty("employeeCSVFileName");
		cSVFileWriter.write(list, rootFilePath, employeeCSVFileName, CharacterCode.UTF_8.toString(), true, EmployeeBean.class);
		
		String companyCSVFileName = context.getConfiguration().getProperty("companyCSVFileName");
		List<CompanyBean> beanList = cSVFileReader.read(rootFilePath, companyCSVFileName, CharacterCode.UTF_8.toString(), CompanyBean.class);
		logger.debug(beanList);
		
		for(CompanyBean bean3 : beanList) {
			String dayString = bean3.getEstablishedDayString();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			try {
				bean3.setEstablishedDay(new Date(sdf.parse(dayString).getTime()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Result<T> result2 = (Result<T>) companyInsertDao.execute(bean3);
			logger.debug(result2);
		}

		return null;
	}
}
