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
import com.neo.service.StudentService;

public class StudentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	StudentService studentService = new StudentService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("checkPersonalInfo")) {
			System.out.println("查看个人信息");
			checkPersonalInfo(request,response);
		} else if (method.equals("updatePersonalInfo")) {
			updatePersonalInfo(request, response);
		} else if (method.equals("toUpadtePersonalInfo")){
			System.out.println("跳转到修改个人信息界面");
			toUpdatePersonalInfo(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void checkPersonalInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/student/checkPersonalInfo.jsp"); //定向的页面 
		request.setAttribute("username", student.getStudentName());
		request.setAttribute("phoneNo", student.getPhoneNo());
		rd.forward(request, response); 
	}	
	
	private void toUpdatePersonalInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/student/upadtePersonalInfo.jsp"); //定向的页面 
		rd.forward(request, response); 
	}	
	
	private void updatePersonalInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		ServletContext context = getServletContext(); 
		Student student = (Student) session.getAttribute("student");
		student.setPhoneNo(request.getParameter("phoneNo"));
		student.setStudentId(request.getParameter("username"));
		try {
			studentService.updateStudent(student);
		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/fail.jsp"); //定向的页面 
			rd.forward(request, response); 
		}
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/success.jsp"); //定向的页面 
		rd.forward(request, response); 
	}	
}	
