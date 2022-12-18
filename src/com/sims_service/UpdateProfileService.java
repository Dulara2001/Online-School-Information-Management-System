package com.sims_service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sims_models.Auth;
import com.sims_models.Student;
import com.sims_util.DbConnection;

public class UpdateProfileService {
	static Connection con;
	
	
	public static Auth selectAuthInfo(int auid) {
		Auth user = null;
		try {
			con = DbConnection.getConnection();
			String query = "select * from online_school_ims.auth where AUID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, auid);
			
			ResultSet rs = stmt.executeQuery();
			
			String uname,pwd;
			
			if(rs.next()) {
				uname = rs.getString("userName");
				pwd = rs.getString("password");
				user = new Auth(auid, uname, pwd);	
			}	
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;
		
	}
	
	public static boolean checkPassword(int auid, String pwd, String npwd) {
		boolean isAdded = false;
		try {	
			con = DbConnection.getConnection();
			
			String query = "select * from online_school_ims.auth where AUID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, auid);
			
			ResultSet rs = stmt.executeQuery();
			String password = null;
			if(rs.next()) {
				password = rs.getString("password");
				if (password.equals(pwd)) {
					isAdded = updatePassword(auid, password, npwd);
				} else {
					System.out.println("");
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isAdded;
		
	}
	
	public static boolean updatePassword(int auid, String pwd, String npwd) {
		boolean isAdded = false;
		
		try {
			con = DbConnection.getConnection();
			String query = "update online_school_ims.auth set password = ? where auid = ?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, npwd);
			stmt.setInt(2, auid);
			
			int i = stmt.executeUpdate();
			
			if(i>0) {
				isAdded = true;
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isAdded;
		
	}
	
	public static Student selectStudentInfo(int auid) {
		Student std = null;
		
		
		try {
			con = DbConnection.getConnection();
			
			String query = "select * from online_school_ims.student where AUID = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, auid);
			
			ResultSet rs = stmt.executeQuery();
			
			String name,address,contact,className,image;
			int sid,age,grade;
			
			if(rs.next()) {
				sid = rs.getInt("SID");
				name = rs.getString("name");
				address = rs.getString("address");
				contact = rs.getString("contact");
				className= rs.getString("class");
				image = rs.getString("profilePic");
				age = rs.getInt("age");
				grade = rs.getInt("grade");
				
				//System.out.println(sid+name+address+contact+className+image+age+grade);
				
				std = new Student(sid,name,age,address,contact,grade,className,image,auid);
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
		
		
		
		return std;
		
	}
	
	public static void updateProfile(int auid, String uname, String name, String address, String contact) {
		try {
			con = DbConnection.getConnection();
			
			String auth_query = "update online_school_ims.auth set userName = ? where AUID= ?";
			PreparedStatement auth_stmt = con.prepareStatement(auth_query);
			
			auth_stmt.setString(1, uname);
			auth_stmt.setInt(2, auid);
			
			int i = auth_stmt.executeUpdate();
			
			System.out.println(i+ " rows affected");
			
			String std_query = "update online_school_ims.student set name = ?, address = ?, contact = ? where AUID= ?";
			
			PreparedStatement std_stmt = con.prepareStatement(std_query);
			
			std_stmt.setString(1, name);
			std_stmt.setString(2, address);
			std_stmt.setString(3, contact);
			std_stmt.setInt(4, auid);
			
			int j = std_stmt.executeUpdate();
			
			System.out.println(j+ " rows affected");
			
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
}
