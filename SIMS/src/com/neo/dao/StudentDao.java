package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.neo.domain.Student;
import com.neo.utils.JdbcUtils;

public class StudentDao {
	
	/**
	 * 根据姓名密码查学生
	 * @param studentName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public Student getStudent(String studentName, String password) throws Exception{
		String sql = "select * from student where studentName=? and password=?";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, studentName);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Student student = null;
		if ( rs.next() ) {
			student = new Student();
			student.setStudentId(rs.getString("studentId"));
			student.setPassword(rs.getString("password"));
			student.setStudentName(rs.getString("studentName"));
			student.setPhoneNo(rs.getString("phoneNo"));
		}
		return student;
	}
	
	/**
	 * 获取所有学生信息
	 * @return
	 * @throws Exception
	 */
	public List<Student> getStudentList() throws Exception{
		String sql = "select * from student";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Student> studentList = new ArrayList<>();
		if ( rs.next() ) {
			Student student = new Student();
			student.setStudentId(rs.getString("studentId"));
			student.setPassword(rs.getString("password"));
			student.setStudentName(rs.getString("studentName"));
			studentList.add(student);
		}
		return studentList;
	}
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean updateStudent(Student student) throws Exception{
		String sql = "update student set classId=?, studentName=?, password=?, phoneNo=?  where studentId=? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStudentId());
		ps.setString(2, student.getStudentName());
		ps.setString(3, student.getPassword());
		ps.setString(4, student.getPhoneNo());
		ps.setString(5, student.getStudentId());
		boolean result = ps.execute();  
		return result;
	}
	/**
	 * 删除学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean deleteStudent(Student student) throws Exception{
		String sql = "delete from student where studentId=? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		boolean result = ps.execute();  
		return result;
	}
	/**
	 * 增加学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean addStudent(Student student) throws Exception{
		String sql = "insert into student (studentId, classId, studentName, password, phoneNo) values(?,?,?,?,?) ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, student.getStudentName());
		ps.setString(3, student.getPassword());
		ps.setString(4, student.getPhoneNo());
		ps.setString(5, student.getStudentId());
		boolean result = ps.execute();  
		return result;
	}
//	/**
//	 * 根据学生获取成绩
//	 * @param studentId
//	 * @return
//	 * @throws Exception
//	 */
//	public StudentGrade getGradesByStudentId(String studentId) throws Exception{
//		String sql = "select * from student_grade where studentId=? ";
//		Connection conn = JdbcUtils.getConncetion();
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, studentId);
//		ResultSet rs = ps.executeQuery();
//		StudentGrade studentGrade = null;
//		if ( rs.next() ) {
//			studentGrade = new StudentGrade();
//			studentGrade.setStudentId(rs.getString("studentId"));
//			studentGrade.setChineseGrade(rs.getFloat("chineseGrage"));
//			studentGrade.setMathGrade(rs.getFloat("mathGrade"));
//			studentGrade.setEnglishGrade(rs.getFloat("enlishGrade"));
//		}
//		return studentGrade;
//	}
//	/**
//	 * 根据班级查总成绩
//	 * @param classId
//	 * @return
//	 * @throws Exception
//	 */
//	public List<StudentGrade> getGradesByClassId(String classId) throws Exception{
//		String sql = "select * from student_grade where classId=? ";
//		Connection conn = JdbcUtils.getConncetion();
//		PreparedStatement ps = conn.prepareStatement(sql);
//		ps.setString(1, classId);
//		ResultSet rs = ps.executeQuery();
//		List<StudentGrade> studentGradeList = new ArrayList<StudentGrade>();
//		if ( rs.next() ) {
//			StudentGrade studentGrade = new StudentGrade();
//			studentGrade.setStudentId(rs.getString("studentId"));
//			studentGrade.setChineseGrade(rs.getFloat("chineseGrage"));
//			studentGrade.setMathGrade(rs.getFloat("mathGrade"));
//			studentGrade.setEnglishGrade(rs.getFloat("enlishGrade"));
//			studentGradeList.add(studentGrade);
//		}
//		return studentGradeList;
//	}
	
	/**
	 * 产生随机ID
	 * @return
	 */
	private String generateId() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}

	public static void main(String[] args) throws Exception {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.getStudent("李四", "123");
		System.out.println(student.getStudentName());
	}
}
