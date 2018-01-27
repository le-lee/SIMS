package com.neo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neo.domain.Student;
import com.neo.service.StudentService;
import com.neo.utils.Page;

public class TeacherServlet extends BaseServlet{
	//TODO 将页面跳转请求响应，和学生管理的增删改查业务操作请求响应分开，页面跳转以后，再请求具体的数据
	
	private static final long serialVersionUID = 1L;

	StudentService studentService = new StudentService();
	
	@Override
	public void init(){
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		try {
			switch (method){
			/********页面跳转***********/
			case "toMain":			//主页
				toMain(request,response);
				break;		
			case "student_manage":	//学生管理
				toStudentManage(request,response);
				break;		
			case "grade_manage":	//成绩管理
				toGradeManage(request,response);
				break;
			case "toResetPwd":		//重置密码
				toResetPwd(request,response);
				break;
			case "toPersonalInfo":	//个人信息
				toPersonalInfo(request, response);
				break;
				/********学生管理具体功能***********/
				//申请返回编辑页面
			case "toEditStudent":
				toEditStudent(request, response);
				break;
			case "deleteStudent":
				deleteStudent(request, response);
				break;
			case "updateStudent":
				updateStudent(request, response);
				break;
			case "saveStudent":
				saveStudent(request, response);
			case "getStudent":
				getStudent(request, response);
			default: 
				toMain(request,response);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * 主页
	 */
	private void toMain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/teacher_main.jsp"); //定向的页面 
		rd.forward(request, response); 
	}	
	/**
	 * 重置密码
	 */
	private void toResetPwd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/teacher_reset_pwd.jsp"); //定向的页面 
		rd.forward(request, response); 

	}
	/***
	 * 成绩管理
	 */
	private void toGradeManage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ServletContext context = getServletContext(); 
		String contextPath = context.getContextPath();
		HttpSession session = request.getSession();
		session.setAttribute("contextPath", contextPath);
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/teacher_gradeManage.jsp");
		rd.forward(request, response); 

	}
	/***
	 * 学生管理
	 */
	private void toStudentManage(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
			studentList = getStudentList(page);
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
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/teacher_studentManage.jsp");
		rd.forward(request, response); 
	}
	/***
	 * 跳转到个人信息
	 */
	private void toPersonalInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/teacher_personal_info.jsp"); //定向的页面 
		rd.forward(request, response); 
	}	
	
	private void toEditStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("to");
		//TODO 待修改为@RequesMapping， springMVC返回页面的机制。
		//捕捉到了页面请求，怎么返回页面
//		PrintWriter writer =  response.getWriter();
//		writer.write("hello");
//		writer.flush();
//		writer.close();
		
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/teacher/student_edit.jsp"); //定向的页面 
		rd.forward(request, response); 
		
		
	}
	/**
	 * 保存学生
	 */
	private String saveStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		String studentNo = request.getParameter("studentNo");
		String gradeId = request.getParameter("gradeId");
		String classId = request.getParameter("classId");
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentNo(studentNo);
		student.setClassId(classId);
		student.setGradeId(gradeId);
		
		boolean result = false;
		//判断新增还是更新
		if (studentId == null) {
			//新增
			result = studentService.addStudent(student);
		} else {
			result = studentService.updateStudent(student);
		}
		if (result == true) {
			return "操作成功";
		}
		return "操作失败";
	}	
	
	/**
	 * 删除学生
	 */
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String message = "删除成功";
		try{
			studentService.deleteStudent(studentId);
		} catch(Exception e){
			message = "删除失败";
		} 
		request.setAttribute("message", message);
		ServletContext context = getServletContext(); 
		RequestDispatcher rd = context.getRequestDispatcher("/TeacherServlet?method=checkStudentInfo");
		rd.forward(request, response); 
	}
	
	/**
	 * 修改学生信息
	 */
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Student student = new Student();
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		student.setStudentId(studentId);
		student.setStudentName(studentName);
		studentService.updateStudent(student);
	}	
	
	/**
	 * 获取某个学生信息
	 */
	private Student getStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String studentId = request.getParameter("studentId");
		return studentService.getStudent(studentId);
	}	
	
	/**
	 * 获取学生信息列表
	 */
	private List<Student> getStudentList(Page page) throws Exception {
		return studentService.getStudentList(page.getPageNo(), page.getPageSize());
	}	

}	
