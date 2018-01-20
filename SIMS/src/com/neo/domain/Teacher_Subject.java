package com.neo.domain;

import java.io.Serializable;
/**
 * 老师-科目类
 * @author le
 *
 */
public class Teacher_Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String subjectId;	//科目id
	private String teacherId;	//老师id
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	
}
