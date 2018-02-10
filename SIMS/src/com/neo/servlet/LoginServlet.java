package com.neo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.neo.domain.Student;
import com.neo.domain.Teacher;
import com.neo.exception.BussinessException;
import com.neo.service.StudentService;
import com.neo.service.TeacherService;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentService studentService = new StudentService();
	private TeacherService teacherService = new TeacherService();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = getServletContext(); 
		String contextPath = context.getContextPath();
		
		String code = request.getParameter("code");
		if ( checkCode(session, code).equals("验证通过")) {
			response.setContentType("text/html; charset=utf-8"); 
			request.setAttribute("contextPath", contextPath);
			String userType = request.getParameter("userType");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			session.setAttribute("userType", request.getParameter("userType"));
			if (userType.equals("student")) {
				studentLogin(request, response, context, username, password);
			} else {
				teacherLogin(request, response, context, username, password);
			}
		} else {
			String message = checkCode(session, code);
			request.setAttribute("message", message);
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/login/index.jsp"); //定向的页面 
			rd.forward(request, response); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/** 
	 * 验证码验证 
	 * @param session 
	 * @param code 
	 * @throws Exception 
	 */  
	private String checkCode(HttpSession session, String code) {  
		String message = "验证通过";
		String codeSession = (String) session.getAttribute("code");  
		if (StringUtils.isEmpty(codeSession)) {  
			message = "没有生成验证码信息";
			return message;
		}  
		if (StringUtils.isEmpty(code)) {  
			message = "未填写验证码信息";
			return message;
		}  
		if (codeSession.equalsIgnoreCase(code)) {  
			// 验证码通过  
			return message;
		} else {  
			message = "验证码错误";
			return message;
		}  
	}  

	private void studentLogin(HttpServletRequest request, HttpServletResponse response, ServletContext context, String username, String password) throws ServletException, IOException{
		System.out.println(username+ password);
		Student student = studentService.getStudent(username, password);
		System.out.println(student);
		if (student != null){
			//登录通过
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/student/student_main.jsp"); //定向的页面 
			request.setAttribute("username", username);
			HttpSession session = request.getSession();

			session.setAttribute("student", student);		//当前用户存入session
			rd.forward(request, response); 
		}else {
			RequestDispatcher rd = context.getRequestDispatcher("/index.jsp"); //定向的页面 
			String message = "登录失败,请检查用户名密码";
			request.setAttribute("message", message);
			rd.forward(request, response); 
		}
	}

	private void teacherLogin(HttpServletRequest request, HttpServletResponse response, ServletContext context, String username, String password) throws ServletException, IOException{
		Teacher teacher = teacherService.getTeacher(username, password);
		System.out.println(teacher);
		if (teacher != null){
			//登录通过
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/teacher_main.jsp"); //定向的页面 
			request.setAttribute("username", username);
			request.getSession().setAttribute("teacher", teacher);	//当前用户存入session
			rd.forward(request, response); 
		}else {
			RequestDispatcher rd = context.getRequestDispatcher("/index.jsp"); //定向的页面 
			String message = "登录失败,请检查用户名密码";
			request.setAttribute("message", message);
			rd.forward(request, response); 
		}
	}
}
