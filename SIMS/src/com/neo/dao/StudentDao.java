package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neo.domain.Student;
import com.neo.utils.JdbcUtils;

public class StudentDao {
	
	/**
	 * 根据姓名密码获取
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
			student.setClassId(rs.getString("classId"));
			student.setGradeId(rs.getString("gradeId"));
			student.setStudentName(rs.getString("studentName"));
			student.setStudentNo(rs.getString("studentNo"));
			student.setPhoneNo(rs.getString("phoneNo"));
			student.setHometown(rs.getString("hometown"));
		}
		return student;
	}
	
	public Student getStudent(String studentId) throws Exception {
		String sql = "select * from student where studentId=?";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, studentId);
		ResultSet rs = ps.executeQuery();
		Student student = null;
		if ( rs.next() ) {
			student = new Student();
			student.setStudentId(rs.getString("studentId"));
			student.setPassword(rs.getString("password"));
			student.setClassId(rs.getString("classId"));
			student.setGradeId(rs.getString("gradeId"));
			student.setStudentName(rs.getString("studentName"));
			student.setStudentNo(rs.getString("studentNo"));
			student.setPhoneNo(rs.getString("phoneNo"));
			student.setHometown(rs.getString("hometown"));
		}
		return student;
	}
	
	/**
	 * 获取所有学生信息
	 * @return
	 * @throws Exception
	 */
	public List<Student> getStudentList(int startIndex, int pageSize) throws Exception {
		//后面的这个变量已经设定了
		//页面需要展示的数据，当前是第几页，当前这个页的第一个数据的索引是多少。
		//一共有多少条记录，下一页，或者后面几页的url
		String sql = "select * from student where 1=1 and deleteFlag = 0 order by studentId  limit ?, ? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, startIndex);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		List<Student> studentList = new ArrayList<>();
		while ( rs.next() ) {
			Student student = new Student();
			student.setStudentId(rs.getString("studentId"));
			student.setPassword(rs.getString("password"));
			student.setClassId(rs.getString("classId"));
			student.setGradeId(rs.getString("gradeId"));
			student.setStudentName(rs.getString("studentName"));
			student.setStudentNo(rs.getString("studentNo"));
			student.setPhoneNo(rs.getString("phoneNo"));
			student.setHometown(rs.getString("hometown"));
			studentList.add(student);
		}
		return studentList;
	}
	
	/**
	 * 计数
	 * @return
	 * @throws Exception
	 */
	public int getStudentCount()throws Exception {
		int studentCount = 0;
		String sql = "select count(*) as studentCount from student ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			studentCount = rs.getInt("studentCount");	
		}
		return studentCount; 
	}
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean updateStudent(Student student) throws Exception{
		String sql = "update student set classId=?, gradeId=?, studentNo=?,studentName=?, password=?, phoneNo=?  where studentId=? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStudentId());
		ps.setString(2, student.getGradeId());
		ps.setString(3, student.getStudentNo());
		ps.setString(4, student.getStudentName());
		ps.setString(5, student.getPassword());
		ps.setString(6, student.getPhoneNo());
		ps.setString(7, student.getStudentId());
		boolean result = ps.execute();  
		return result;
	}
	/**
	 * 删除学生
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public boolean deleteStudent(String studentId) throws Exception{
//		String sql = "delete from student where studentId=? ";
		String sql = "update student set deleteFlag = 1 where studentId=? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, studentId);
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
		String sql = "insert into student (studentId, classId, gradeId, studentNo, studentName, password, phoneNo,hometown) values(?,?,?,?,?,?,?,?) ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, student.getStudentId());  
		ps.setString(2, student.getClassId());
		ps.setString(3, student.getGradeId());
		ps.setString(4, student.getStudentNo());
		ps.setString(5, student.getStudentName());
		ps.setString(6, student.getPassword());
		ps.setString(7, student.getPhoneNo());
		ps.setString(8, student.getHometown());
		boolean result = ps.execute();  
		return result;
	}

}
