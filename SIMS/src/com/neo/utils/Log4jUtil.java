package com.neo.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jUtil {
	private static Log4jUtil log4jUtil;
	private Logger logger;
	
	public Log4jUtil(String configPath) {
		PropertyConfigurator.configure(configPath);
		this.logger = Logger.getLogger(Log4jUtil.class);
	}
	
	public static Log4jUtil getLog4jUtil() {
		if(log4jUtil == null) {
			 log4jUtil = new Log4jUtil("config/log4j.properities");
		}
		return log4jUtil;
	}
	
	public static void debug(String str) {
        log4jUtil.logger.debug(str);
    }

    public static void info(String str) {
        log4jUtil.logger.info(str);
    }

    public static void warn(String str) {
        log4jUtil.logger.warn(str);
    }

    public static void error(String str) {
        log4jUtil.logger.error(str);
    }
}
