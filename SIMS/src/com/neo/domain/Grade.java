package com.neo.domain;

import java.io.Serializable;
/**
 * 年级类
 * @author le
 */
public class Grade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String gradeId;		//年级id
	private String gradeName;	//年级名称
	
	public String getGradeId() {
		return gradeId;
	}
	public void setGradeId(String gradeId) {
		this.gradeId = gradeId;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
}
