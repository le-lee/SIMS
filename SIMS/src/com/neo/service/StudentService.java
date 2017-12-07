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
	public boolean deleteStudent(Student student) throws Exception{
		return studentDao.deleteStudent(student);
	}
	public boolean updateStudent(Student student) throws Exception{
		return studentDao.updateStudent(student);
	}
	public List<Student> getStudentList(){
		return null;
	}
	
}
