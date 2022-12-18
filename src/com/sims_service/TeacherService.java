package com.sims_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sims_models.Subject;
import com.sims_models.Teacher;
import com.sims_util.DbConnection;

public class TeacherService {
	
private static Connection conn;
	
	private static final String SELECT_USER_BY_ID = "select name, age, address, contact, SBID, profilePic from teacher where AUID=?";
	private static final String SELECT_SUBJECT_BY_ID = "select name from subject where SBID=?";
	
	public static Teacher selectTeacherById(int id) {
		Teacher teacher = null;
		
		try{
			conn = DbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_ID);
			stmt.setInt(1, id);
			System.out.println(stmt);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				String name, address, contact, profilePic;
				int SBID, age;
				
				name = rs.getString("name");
				age = rs.getInt("age");
				address = rs.getString("address");
				contact = rs.getString("contact");
				SBID = rs.getInt("SBID");
				profilePic = rs.getString("profilePic");
				
				teacher = new Teacher(name, age, address, contact, SBID, profilePic, id); 
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return teacher;
	}
	
	public static Subject getSubjectName(int sbid) {
		Subject subject = null;
		
		try {
			conn = DbConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_SUBJECT_BY_ID);
			stmt.setInt(1, sbid);
			System.out.println(stmt);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String name;
				
				name = rs.getString("name");
				
				subject = new Subject(sbid, name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return subject;
	}

}
