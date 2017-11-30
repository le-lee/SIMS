package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.neo.domain.Teacher;
import com.neo.utils.JdbcUtils;

public class TeacherDao {
	
	public Teacher getTeacher(String teacherName, String password) throws Exception{
		String sql = "select * from teacher where teacherName=? and password=?";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teacherName);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		Teacher teacher =null;
		if ( rs.next() ) {
			teacher = new Teacher();
			teacher.setTeacherId(rs.getString("teacherId"));
			teacher.setPassword(rs.getString("password"));
			teacher.setTeacherName(rs.getString("teacherName"));
		}
		return teacher;
	}
	
	public boolean updateTeacher(Teacher teacher) throws Exception{
		String sql = "update teacher set  teacherName=?, password=?  where teacherId=? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, teacher.getTeacherName());
		ps.setString(2, teacher.getPassword());
		ps.setString(3, teacher.getTeacherId());
		boolean result = ps.execute();  
		return result;
	}
}
