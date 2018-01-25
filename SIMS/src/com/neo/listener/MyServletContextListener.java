package com.neo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.PropertyConfigurator;

public class MyServletContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		//真实路径
		String prefix = servletContext.getRealPath("/");
		System.out.println("servletContext.getRealPath(): "+prefix);
		
		String log4jPath = servletContext.getInitParameter("log4j");
		String log4jConfigPath = prefix + log4jPath;
		PropertyConfigurator.configure(log4jConfigPath);
		System.out.println("initialized log4j finish");
		//当前应用为SIMS，在应用范围里面访问资源的路径
		String contextPath = servletContext.getContextPath();
		System.out.println("servletContext.getContextPath(): "+contextPath);
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("context destroyed");
	}

}
