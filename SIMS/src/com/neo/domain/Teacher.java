package com.neo.domain;

import java.io.Serializable;

public class Teacher implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String teacherId;
	private String teacherName;
	private String password;
	
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
