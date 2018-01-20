package com.neo.domain;

import java.io.Serializable;

/**
 * 班级类
 * @author le
 */
public class Class implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String classId;		//班级id
	private String className;	//班级名称
	private String teacherId;	//老师（班主任）id
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
}
