package com.neo.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import com.neo.utils.Page;

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
		String pageNo = request.getParameter("pageNo");
		String pageSize = request.getParameter("pageSize");
		Page page = new Page();
		//取值
		if (pageNo != null && pageNo.matches("^[0-9]+$") ) {
			page.setPageNo(new Integer(pageNo));				//设置当前页数
		} else {
			page.setPageNo(0);
		}
		
		if (pageSize != null && pageSize.matches("^[0-9]+$")) {
			page.setPageSize(new Integer(pageSize));			//设置页面大小
		} else {
			page.setPageSize(Page.DEFAUL_PAGE_SIZE);
		}
		
		List<Student> studentList = new ArrayList<>();
		try {
			int studentCount = studentService.getStudentCount();
			studentList = studentService.getStudentList(page.getPageNo(), page.getPageSize());
			page.setTotalRecord(studentCount);						//设置总记录数
			int operationResult = (studentCount % page.getPageSize());
			int totalPageNo = operationResult == 0 ? operationResult : studentCount / page.getPageSize() + 1;
			page.setTotalPageNo(totalPageNo);						//设置总页数
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("studentList", studentList);
		request.setAttribute("page", page);
		
		ServletContext context = getServletContext(); 
		String contextPath = context.getContextPath();
		HttpSession session = request.getSession();
		session.setAttribute("contextPath", contextPath);
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/studentManage/studentMange.jsp");
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
