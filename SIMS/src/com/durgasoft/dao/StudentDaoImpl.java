package com.durgasoft.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.durgasoft.beans.Student;
import com.durgasoft.factory.ConnectionFactory;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String add(Student student) {
		String status="";
		try {
			Student std = search(student.getSid());
			if(std==null) {
				Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?)");
				pst.setString(1, student.getSid());
				pst.setString(2, student.getSname());
				pst.setString(3, student.getSaddr());
				int rowCount = pst.executeUpdate();
				if(rowCount ==1) {
					status ="success";
				}else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student search(String sid) {
		Student student = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from student where SID = ?");
			pst.setString(1,sid);
			ResultSet rs= pst.executeQuery();
			boolean b = rs.next();
			if(b==true) {
				student = new Student();
				student.setSid(rs.getString("SID"));
				student.setSname(rs.getString("SNAME"));
				student.setSaddr(rs.getString("SADDR"));
			}else {
				student = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public String update(Student student) {
		String status="";
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pst = con.prepareStatement("update student set SNAME=?,SADDR=? where SID = ?");
			pst.setString(1, student.getSname());
			pst.setString(2, student.getSaddr());
			pst.setString(3, student.getSid());
			int rowCount = pst.executeUpdate();
			if(rowCount == 1) {
				status = "success";
			}else {
				status="failure";
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		String status="";
		try {
			Student student =search(sid);
			if (student == null) {
				status ="notexisted";
			} else {
				Connection con = ConnectionFactory.getConnection();
				PreparedStatement pst = con.prepareStatement("delete from student where SID=?");
				pst.setString(1, sid);
				int rowCount = pst.executeUpdate();
				if (rowCount == 1) {
					status="success";
				} else {
					status="failure";
				}
			}
		} catch (Exception e) {
			status="failure";
			e.printStackTrace();
		}
		return status;
	}

}
