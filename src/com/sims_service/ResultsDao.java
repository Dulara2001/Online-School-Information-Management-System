package com.sims_service;

import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import com.sims_models.Marks;
import com.sims_models.Notices;
import com.sims_util.DbConnection;

public class ResultsDao {
	public static Connection con;
	
	public static void addResults(Marks m) {
		try {
			con = DbConnection.getConnection();
			
			String query = "insert into online_school_ims.marks values (?,?,?,?,?)";
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, m.getSid());
			stmt.setInt(2, m.getSbid());
			stmt.setString(3, m.getExam());
			stmt.setInt(4, m.getGrade());
			stmt.setDouble(5, m.getResult());
			
			
			int i = stmt.executeUpdate();
			System.out.print(i + " rows added");
			
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
	
	public static Marks[] getResults(int sid, String exam_year) {
		
		Marks marks[] = new Marks[0];
		
		try {
			con = DbConnection.getConnection();
			String get_marks_query = "select * from online_school_ims.marks where SID = ? and exam = ?";
			
			PreparedStatement stmt = con.prepareStatement(get_marks_query);
			stmt.setInt(1, sid);
			stmt.setString(2, exam_year);
			
			ResultSet rs = stmt.executeQuery();
			
			
			if (!rs.next()) {
				System.out.println("No Notices");
			} 
			else {
				do {
					int id,grade,sbid;
					double result;
					String exam, subject;
					
					id = rs.getInt("SID");
					sbid = rs.getInt("SBID");
					grade = rs.getInt("grade");
					exam = rs.getString("exam");
					result = rs.getInt("result");
					
					String subject_query = "select name from online_school_ims.subject where SBID = ?";
					PreparedStatement subject_stmt = con.prepareStatement(subject_query);
					subject_stmt.setInt(1, sbid);
					
					ResultSet subject_rs = subject_stmt.executeQuery();
					subject_rs.next();
					subject = subject_rs.getString("name");
					
					System.out.print(subject);
					
					marks = Arrays.copyOf(marks, marks.length + 1);
					marks[marks.length - 1] = new Marks(id, subject, grade,exam,result);
				}
				while(rs.next()); 
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
		
		return marks;
		
	
	}
	
}
