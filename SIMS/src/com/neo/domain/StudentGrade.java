package com.neo.domain;

import java.io.Serializable;

public class StudentGrade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String studentId;
	private float mathGrade;
	private float chineseGrade;
	private float englishGrade;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public float getMathGrade() {
		return mathGrade;
	}
	public void setMathGrade(float mathGrade) {
		this.mathGrade = mathGrade;
	}
	public float getChineseGrade() {
		return chineseGrade;
	}
	public void setChineseGrade(float chineseGrade) {
		this.chineseGrade = chineseGrade;
	}
	public float getEnglishGrade() {
		return englishGrade;
	}
	public void setEnglishGrade(float englishGrade) {
		this.englishGrade = englishGrade;
	}
	
}
