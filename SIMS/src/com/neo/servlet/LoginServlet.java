package com.neo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neo.domain.Student;
import com.neo.domain.Teacher;
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
		response.setContentType("text/html; charset=utf-8"); 
		ServletContext context = getServletContext(); 
		String contextPath = context.getContextPath();
		request.setAttribute("contextPath", contextPath);
		String userType = request.getParameter("userType");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (userType.equals("student")) {
			studentLogin(request, response, context, username, password);
		} else {
			teacherLogin(request, response, context, username, password);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void studentLogin(HttpServletRequest request, HttpServletResponse response, ServletContext context, String username, String password) throws ServletException, IOException{
		System.out.println(username+ password);
		Student student = studentService.getStudent(username, password);
		System.out.println(student);
		if (student != null){
			//登录通过
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/student/studentMain.jsp"); //定向的页面 
			request.setAttribute("username", username);
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
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
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/teacherMain.jsp"); //定向的页面 
			request.setAttribute("username", username);
			request.getSession().setAttribute("teacher", teacher);
			rd.forward(request, response); 
		}else {
			RequestDispatcher rd = context.getRequestDispatcher("/index.jsp"); //定向的页面 
			String message = "登录失败,请检查用户名密码";
			request.setAttribute("message", message);
			rd.forward(request, response); 
		}
	}
}
