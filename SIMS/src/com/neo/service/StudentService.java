package com.neo.service;

import java.util.List;

import com.neo.dao.StudentDao;
import com.neo.domain.Student;

public class StudentService {
	
	StudentDao studentDao = new StudentDao();
	
	public Student getStudent(String studentName, String password) {
		Student student = null;
		try {
			student = studentDao.getStudent(studentName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}
	public boolean addStudent(Student student) throws Exception{
		return studentDao.addStudent(student);
	}
	public boolean deleteStudent(String studentId) throws Exception{
		return studentDao.deleteStudent(studentId);
	}
	public boolean updateStudent(Student student) throws Exception{
		return studentDao.updateStudent(student);
	}
	public List<Student> getStudentList(int pageNo, int pageSize) throws Exception{
		int startIndex = pageNo;
		if (pageNo != 0){
			startIndex = pageNo * pageSize - 1;
		} 
		
		return studentDao.getStudentList(startIndex, pageSize);
	}
	
	public int getStudentCount() throws Exception{
		int studentCount = studentDao.getStudentCount();
		return studentCount;
	}	
}
