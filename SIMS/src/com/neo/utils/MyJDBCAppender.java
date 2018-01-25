package com.neo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.LoggingEvent;

//TODO 查看下Log4j的JDBCAppender
public class MyJDBCAppender extends JDBCAppender{
	private LoggingEvent e;  
	private Logger logger;  
	private JDBCAppender jdbcAppender; 
	
	public MyJDBCAppender() {  
		logger = Logger.getLogger(MyJDBCAppender.class.getName());  
		// 测试，使用jdbc来保存日志信息  
		testJDBCAppender();  
	}  
	/** 
	 * 可以修改这个方法，实现PreparedStatement，Connection得重用 
	 */  
	protected void execute(String sql) throws SQLException {  
		Connection con = null;  
		PreparedStatement stmt = null;  
		try {  
			con = JdbcUtils.getConncetion();  
			stmt = con.prepareStatement(this.getSql());  
			stmt.setString(1, e.getLoggerName());// LogName  
			stmt.setString(2, e.getLevel().toString());// LogLevel  
			stmt.setString(3, (String) e.getMessage());// MSG  
			stmt.execute();  
		} catch (SQLException e) {  
			if (stmt != null) stmt.close();  
			throw e;  
		} catch (Exception e1) {
			e1.printStackTrace();
		}  
		stmt.close();  
		closeConnection(con);  
	}  

	/******************************************************************************************* 
	 * *保存日志事件 
	 ******************************************************************************************/  
	protected String getLogStatement(LoggingEvent event) {  
		e = event;  
		return getLayout().format(event);  
	}  

	

	/*********************************************************************************************** 
	 * 写信息到日志中去 
	 **********************************************************************************************/  
	private void writeLogInfo() {  
		logger.addAppender(jdbcAppender);  
		logger.setLevel(Level.ALL);  
		logger.debug("aaa   debug   info");  
		// logger.debug("aaa debug info.aaa");  
		logger.info("bbb   info");  
		logger.warn("warn   info");  
		logger.error("error   info");  
		logger.fatal("fatal   info");  
	}  

	private void testJDBCAppender() {  
		jdbcAppender = new MyJDBCAppender();  
		// 下面的参数可以自己修改满足自己的要求  
		// 设置 日志数据库保存使用的参数，可以采用配置文件的方式来加载信息
		
		jdbcAppender.setDriver("com.mysql.jdbc.Driver");  
		jdbcAppender.setURL("jdbc:mysql://localhost:3306/grade_management");  
		jdbcAppender.setUser("sa");  
		jdbcAppender.setPassword("123456");  
		jdbcAppender.setSql("insert   into   log (log_name, log_level, message)   values   (?,?,?)");  
		// 测试使用数据库保存日志信息  
		writeLogInfo();  
		jdbcAppender.close();  
	}  

	public static void main(String[] args) {  
		MyJDBCAppender wdzTest11 = new MyJDBCAppender();  
	}  
}
