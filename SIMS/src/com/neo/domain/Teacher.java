package com.neo.domain;

import java.io.Serializable;

public class Teacher implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String teacherId;	//老师id
	private String teacherNo;	//职工编号
	private String teacherName;	//老师姓名
	private String password;	//密码
	
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getTeacherNo() {
		return teacherNo;
	}
	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
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
