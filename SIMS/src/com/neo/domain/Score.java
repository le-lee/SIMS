package com.neo.domain;

import java.io.Serializable;
/**
 * 成绩类
 * @author le
 */
public class Score implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String scoreId;		//成绩id
	private String studentId;	//学生id
	private String subjctId;	//科目id
	private int score;		//分数
	public String getScoreId() {
		return scoreId;
	}
	public void setScoreId(String scoreId) {
		this.scoreId = scoreId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getSubjctId() {
		return subjctId;
	}
	public void setSubjctId(String subjctId) {
		this.subjctId = subjctId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
