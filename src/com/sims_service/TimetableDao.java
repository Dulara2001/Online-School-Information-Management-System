package com.sims_service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sims_models.Student;
import com.sims_models.Timetables;
import com.sims_util.DbConnection;

public class TimetableDao {
	private static Connection con;

	private static final String INSERT_TIMETABLE = "insert into online_school_ims.timetables values (?,?,?,?,?,?)";
	private static final String UPDATE_TIMETABLE = "update timetables set year=?, grade=?, class=?, image=? where TID=?";
	private static final String SELECT_TIMETABLE_FOR_TEACHER = "select * from online_school_ims.timetables tb where tb.TID = ?;";
	private static final String SELECT_TIMETABLE_FOR_STUDENT = "select * from online_school_ims.timetables tb where tb.grade = ? and tb.class = ?;";
	private static final String DELETE_TIMETABLE = "delete from online_school_ims.timetables where TTID = ?";
	private static final String GET_LOGGED_IN_TEACHER_ID = "select t.TID from online_school_ims.teacher t where t.AUID = (\r\n"
			+ "select a.AUID from online_school_ims.auth a where a.userName = ?\r\n" + ")";
	private static final String GET_LOGGED_IN_STUDENT_DATA = "select * from online_school_ims.student s where s.AUID = (\r\n"
			+ "select a.AUID from online_school_ims.auth a where a.userName = ?\r\n" + ")";

	public static boolean addTimetables(Timetables timetable) {

		try {
			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(INSERT_TIMETABLE);

			stmt.setInt(1, 0);
			stmt.setInt(2, timetable.getTid());
			stmt.setInt(3, timetable.getYear());
			stmt.setInt(4, timetable.getGrade());
			stmt.setString(5, timetable.getClassName());
			stmt.setString(6, timetable.getImage());

			int isAdded = stmt.executeUpdate();
			System.out.println("No. of records inserted" + isAdded);

			if (isAdded > 0) {
				return true;
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

		return false;

	}
	
	public static boolean updateTimetables(Timetables timetable) {
		
		try {
			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(UPDATE_TIMETABLE);
			
			stmt.setInt(1, timetable.getYear());
			stmt.setInt(2, timetable.getGrade());
			stmt.setString(3, timetable.getClassName());
			stmt.setString(4, timetable.getImage());
			stmt.setInt(5, timetable.getTid());
			
			int isAdded = stmt.executeUpdate();
			System.out.println("No. of records inserted" + isAdded);
			
			if (isAdded > 0) {
				return true;
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
		
		return false;
		
	}

	public static Timetables selectTeacherTimetable(int teacherId) {
		Timetables timetable = null;

		try {
			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_TIMETABLE_FOR_TEACHER);
			stmt.setInt(1, teacherId);
			System.out.println(stmt);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String className, imagePath;
				int year, grade, tid, ttid;

				ttid = rs.getInt("ttid");
				tid = rs.getInt("TID");
				year = rs.getInt("year");
				grade = rs.getInt("grade");
				className = rs.getString("class");
				imagePath = rs.getString("image");

				timetable = new Timetables(ttid, tid, year, grade, className, imagePath);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return timetable;

	}
	
	public static Timetables selectStudentTimetable(Student student) {
		Timetables timetable = null;
		
		try {
			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(SELECT_TIMETABLE_FOR_STUDENT);
			stmt.setInt(1, student.getGrade());
			stmt.setString(2, student.getClassName());
			System.out.println(stmt);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String className, imagePath;
				int year, grade, tid;

				tid = rs.getInt("TID");
				year = rs.getInt("year");
				grade = rs.getInt("grade");
				className = rs.getString("class");
				imagePath = rs.getString("image");

				timetable = new Timetables(tid, year, grade, className, imagePath);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return timetable;
		
	}
	
	public static boolean deleteTimetable(int id) {
		boolean isDeleted = false;
		
		try {
			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(DELETE_TIMETABLE);
			
			stmt.setInt(1, id);
			isDeleted = stmt.executeUpdate() > 0;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isDeleted;
	}

	public static int getLoggedInTeacherID(String username) {
		int teacherID = 0;

		try {

			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(GET_LOGGED_IN_TEACHER_ID);

			stmt.setString(1, username);
			System.out.println(stmt);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				teacherID = rs.getInt("TID");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return teacherID;

	}

	public static Student getLoggedInStudentData(String username) {
		Student student = null;

		try {

			con = DbConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(GET_LOGGED_IN_STUDENT_DATA);

			stmt.setString(1, username);
			System.out.println(stmt);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				String name, address, contact, className, profilePic;
				int sid, grade, age, auid;

				sid = rs.getInt("SID");
				name = rs.getString("name");
				age = rs.getInt("age");
				address = rs.getString("address");
				contact = rs.getString("contact");
				grade = rs.getInt("grade");
				className = rs.getString("class");
				profilePic = rs.getString("profilePic");
				auid = rs.getInt("AUID");
				
				student = new Student(sid,name, age, address, contact, grade, className, profilePic,auid);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;

	}

	
}
