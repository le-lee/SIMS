package com.neo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neo.domain.Student;
import com.neo.service.StudentService;

public class TeacherServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	StudentService studentService = new StudentService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("checkStudentInfo")) {
			System.out.println("查看学生信息");
			try {
				checkStudentInfo(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (method.equals("deleteStudent")) {
			System.out.println("删除学生信息");
			updatePersonalInfo(request, response);
		} else if (method.equals("checkPersonalInfo")){
			System.out.println("跳转到个人信息界面");
			tocheckPersonalInfo(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void checkStudentInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/studentManage/studentMange.jsp"); //定向的页面 
		List<Student> studentList = studentService.getStudentList();
		
		request.setAttribute("studentList", studentList);
		rd.forward(request, response); 
	}	
	
	private void tocheckPersonalInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
