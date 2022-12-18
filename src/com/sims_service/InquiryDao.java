package com.sims_service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sims_models.Inquiry;
import com.sims_util.DbConnection;

public class InquiryDao {
	public static Connection con;
	
	public static void addInquiry(Inquiry inq) {
		try {
			con = DbConnection.getConnection();
			
			String query = "insert into online_school_ims.inquiry values (?,?,?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setInt(1, inq.getIid());
			stmt.setInt(2, inq.getSid());
			stmt.setString(3, inq.getEmail());
			stmt.setString(4, inq.getTitle());
			stmt.setString(5, inq.getInquiry());
			stmt.setInt(6, inq.getResponded());
			
			int i = stmt.executeUpdate();
			
			System.out.print(i + " records inserted");
			
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
	
	public static List<Inquiry> getInquiry() {
		
		List<Inquiry> inquiries = new ArrayList<>();
		
		try {
			con = DbConnection.getConnection();
			
			String sql = "select * from inquiry where responded=0";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int iid = rs.getInt("iid");
				int sid = rs.getInt("sid");
				String email = rs.getString("email");
				String title = rs.getString("title");
				String body = rs.getString("inquiry");
				
				inquiries.add(new Inquiry(iid, sid, email, title, body));
			}
			}catch(Exception e) {
				e.printStackTrace();
			}
		return inquiries;
	}
	
	public static void inquiryResponse(int iid) {
		try {
			con = DbConnection.getConnection();
			String query = "update online_school_ims.inquiry set responded = 1 where iid = ?";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, iid);
			
			int i = stmt.executeUpdate();
			
			System.out.println(i + "rows affected");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
