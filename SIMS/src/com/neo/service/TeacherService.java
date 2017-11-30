package com.neo.service;

import com.neo.dao.TeacherDao;
import com.neo.domain.Teacher;

public class TeacherService {

	private TeacherDao teacherDao = new TeacherDao();

	public Teacher getTeacher(String teacherName, String password){
		Teacher teacher = null;
		try {
			teacher = teacherDao.getTeacher(teacherName, password);
		} catch (Exception e) {
			e.printStackTrace();
			//引入日志机制
			//异常处理
		}
		return teacher;
	}

	public boolean updateTeacher(Teacher teacher){
		boolean result = false;
		try {
			result = teacherDao.updateTeacher(teacher);
		} catch (Exception e) {
			e.printStackTrace();
			//引入日志机制
			//异常处理
		}
		return result;
	}
}
