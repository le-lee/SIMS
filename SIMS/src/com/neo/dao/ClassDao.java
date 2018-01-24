package com.neo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.neo.domain.Class;
import com.neo.utils.JdbcUtils;
import com.neo.utils.UUIDUtis;

public class ClassDao {
	/**
	 * 增加班级
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public boolean addClass(Class clazz) throws Exception{
		String sql = "insert into student (classId, className, teacherId) values(?,?,?) ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, UUIDUtis.generateId());  
		ps.setString(2, clazz.getClassName());
		ps.setString(3, clazz.getTeacherId());
		boolean result = ps.execute();  
		return result;
	}
	
	/**
	 * 删除班级
	 * @param classId
	 * @throws Exception 
	 */
	public boolean deleteClass(String classId) throws Exception{
//		String sql = "delete from class where classId=? ";
		String sql = "update student set deleteFlag = 1 where classId=? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, classId);
		boolean result = ps.execute();  
		return result;
	}
	
	/**
	 * 更新班级
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public boolean updateClass(Class clazz) throws Exception{
		String sql = "update class set classId=?, className=?, teacherId=?";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, clazz.getClassId());
		ps.setString(2, clazz.getClassName());
		ps.setString(3, clazz.getTeacherId());
		boolean result = ps.execute();  
		return result;
	}
	
	public List<Class> getClasses(int startIndex, int pageSize) throws Exception{
		List<Class> classList = new ArrayList<>();
		String sql = "select * from student where 1=1 and deleteFlag = 0 order by classId  limit ?, ? ";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, startIndex);
		ps.setInt(2, pageSize);
		ResultSet rs = ps.executeQuery();
		while ( rs.next() ) {
			Class clazz = new Class();
			clazz.setClassId(rs.getString("classId"));
			clazz.setClassName(rs.getString("className"));
			clazz.setTeacherId(rs.getString("teacherId"));
			classList.add(clazz);
		}
		return classList;
	}
	
	public Class getSingleClass(String classId) throws Exception{
		Class singleClass = null;
		String sql = "select * from class where classId=?";
		Connection conn = JdbcUtils.getConncetion();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, classId);
		ResultSet rs = ps.executeQuery();
		if ( rs.next() ) {
			singleClass = new Class();
			singleClass.setClassId(rs.getString("classId"));
			singleClass.setTeacherId(rs.getString("teacherId"));
			singleClass.setClassName(rs.getString("className"));
		}
		return singleClass;
	}
}
