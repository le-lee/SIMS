package com.neo.domain;

import java.io.Serializable;
/**
 * 科目类
 * @author le
 */
public class Subject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String subjectId;
	private String subjectName;
	
	public String getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
}
