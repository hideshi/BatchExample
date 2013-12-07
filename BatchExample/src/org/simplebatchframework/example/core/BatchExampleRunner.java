package org.simplebatchframework.example.core;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.simplebatchframework.core.Runner;
import org.simplebatchframework.core.exception.BatchDataBaseRuntimeException;
import org.simplebatchframework.core.exception.BatchFileIORuntimeException;
import org.simplebatchframework.core.exception.BatchFrameworkRuntimeException;
import org.simplebatchframework.core.exception.BatchRuntimeException;


public class BatchExampleRunner extends Runner {
	
	private static Logger logger = Logger.getLogger(BatchExampleRunner.class);

	public static void main(String[] args) {
		try {
			RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
			MDC.put("pid", rt.getName());
			run(args);
			System.exit(ExitCode.SUCCESS.getCode());
		} catch(BatchFrameworkRuntimeException e) {
			rollback();
			writeLog(MessageID.E0001, e);
			System.exit(ExitCode.FRAMEWORK_FAILURE.getCode());
		} catch(BatchDataBaseRuntimeException e) {
			rollback();
			writeLog(MessageID.E0002, e);
			System.exit(ExitCode.DATABASE_FAILURE.getCode());
		} catch(BatchFileIORuntimeException e) {
			rollback();
			writeLog(MessageID.E0003, e);
			System.exit(ExitCode.FILE_IO_FAILURE.getCode());
		} catch(BatchRuntimeException e) {
			rollback();
			writeLog(MessageID.E0004, e);
			System.exit(ExitCode.FAILURE.getCode());
		} catch(Throwable e) {
			rollback();
			writeLog(MessageID.E0005, e);
			System.exit(ExitCode.UNEXPECTED_FAILURE.getCode());
		}
	}
	
	private static void writeLog(MessageID messageId, Throwable e) {
		if(context != null && context.getConfiguration() != null) {
			logger.fatal(context.getConfiguration().getProperty(messageId.toString()), e);
		} else {
			logger.fatal(e);
		}
	}
	
	private static void rollback() {
		try {
			context.getConnection().rollback();
		} catch (SQLException e) {
			writeLog(MessageID.E0006, new BatchDataBaseRuntimeException(e));
		}
	}
}
