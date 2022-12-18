package com.sims_service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sims_models.Admin;
import com.sims_models.Auth;
import com.sims_models.Student;
import com.sims_models.Teacher;
import com.sims_util.DbConnection;


public class AdminService {
	private static Connection con;
	
	public static void addStudent(Student std, Auth auth) {
		
		try {
			con = DbConnection.getConnection();
			
			String set_auth_query = "insert into online_school_ims.auth values (?,?,?,?)";
			String student_query = "insert into online_school_ims.student values (?,?,?,?,?,?,?,?,?)";
			String get_auth_query = "select AUID from online_school_ims.auth where userName = ?";
			
			//Set Values to auth table
			PreparedStatement set_auth_stmt = con.prepareStatement(set_auth_query);
			
			set_auth_stmt.setInt(1, auth.getAuid() );
			set_auth_stmt.setString(2, auth.getUserName());
			set_auth_stmt.setString(3, auth.getPassword());
			set_auth_stmt.setString(4, auth.getUserState());
			
			set_auth_stmt.executeUpdate();
			
			//Get auth id from auth table
			PreparedStatement get_auth_stmt = con.prepareStatement(get_auth_query);
			
			get_auth_stmt.setString(1, auth.getUserName());
			
			ResultSet result = get_auth_stmt.executeQuery();
			
			if (result.next()) {
				int auid = result.getInt("AUID");
				
				std.setAuid(auid);

				PreparedStatement student_stmt = con.prepareStatement(student_query);
				
				student_stmt.setInt(1, std.getSid());
				student_stmt.setString(2, std.getName());
				student_stmt.setInt(3, std.getAge());
				student_stmt.setString(4, std.getAddress());
				student_stmt.setString(5, std.getContact());
				student_stmt.setInt(6, std.getGrade());
				student_stmt.setString(7, std.getClassName());
				student_stmt.setString(8, std.getProfilePic());
				student_stmt.setInt(9, std.getAuid());
				
				int i = student_stmt.executeUpdate();
				
				System.out.print(i + " records inserted");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.print("1");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.print("2");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("3");
			e.printStackTrace();
		}
		
	}
	
	public static void addTeacher(Teacher teach, Auth auth) {
		try {
			con = DbConnection.getConnection();
			
			String set_auth_query = "insert into online_school_ims.auth values (?,?,?,?)";
			String teacher_query = "insert into online_school_ims.teacher values (?,?,?,?,?,?,?,?)";
			String get_auth_query = "select AUID from online_school_ims.auth where userName = ?";
			
			//Set values to auth table
			PreparedStatement set_auth_stmt = con.prepareStatement(set_auth_query);
			
			set_auth_stmt.setInt(1, auth.getAuid() );
			set_auth_stmt.setString(2, auth.getUserName());
			set_auth_stmt.setString(3, auth.getPassword());
			set_auth_stmt.setString(4, auth.getUserState());
			
			set_auth_stmt.executeUpdate();
			
			//Get auth id from auth table
			PreparedStatement get_auth_stmt = con.prepareStatement(get_auth_query);
			
			get_auth_stmt.setString(1, auth.getUserName());
			
			ResultSet result = get_auth_stmt.executeQuery();
			
			if (result.next()) {
				int auid = result.getInt("AUID");
				
				teach.setAuid(auid);
				
				//Enter student details with auth id
				PreparedStatement teacher_stmt = con.prepareStatement(teacher_query);
				
				teacher_stmt.setInt(1, teach.getTid());
				teacher_stmt.setString(2, teach.getName());
				teacher_stmt.setInt(3, teach.getAge());
				teacher_stmt.setString(4, teach.getAddress());
				teacher_stmt.setString(5, teach.getContact());
				teacher_stmt.setInt(6, teach.getSbid());
				teacher_stmt.setString(7, teach.getProfilePic());
				teacher_stmt.setInt(8, teach.getAuid());
				
				int i = teacher_stmt.executeUpdate();
				System.out.print(i + "rows added");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static Admin selectAdminById(int id) {
		final String select_user_by_id = "select name, age, address, contact, profilePic from admin where AUID=?";
		Admin admin = null;
		
		try{
			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(select_user_by_id);
			stmt.setInt(1, id);
			System.out.println(stmt);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				String name, address, contact, profilePic;
				int age;
				
				name = rs.getString("name");
				age = rs.getInt("age");
				address = rs.getString("address");
				contact = rs.getString("contact");
				profilePic = rs.getString("profilePic");
				
				admin = new Admin(name, age, address, contact, profilePic, id); 
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return admin;
	}
}
