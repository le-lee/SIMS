package com.neo.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest extends HttpServletRequestWrapper{

	HttpServletRequest request = null;
	
	// TODO 下载servlet-api-3.0.1.jar source文件
	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	
	@Override
	public String getParameter(String name) {
		String method = request.getMethod();
		String value = null;
		try {
			request.setCharacterEncoding("UTF-8");
			value = request.getParameter("name");
			if ("get".equalsIgnoreCase(method)) {
				value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return value;
	}

	@Override
	public String[] getParameterValues(String name) {
		String method = request.getMethod();
		String []values = null;
		try {
			request.setCharacterEncoding("UTF-8");
			values = request.getParameterValues("name");
			if ("get".equalsIgnoreCase(method)) {
				for (int i = 0; i < values.length; i++) {
					values[i] = new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return values;
	}
}
