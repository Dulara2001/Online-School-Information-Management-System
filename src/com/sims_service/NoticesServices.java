package com.sims_service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.sims_models.Notices;
import com.sims_models.Student;
import com.sims_util.DbConnection;

public class NoticesServices {
	private static Connection conn;

	public static void addNotices(Notices notice) throws SQLException, IOException {
		try {
			conn = DbConnection.getConnection();

			String sql = "insert into online_school_ims.notices  values" + "(?,?,?,?,?,?)";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, notice.getNID());
			stmt.setString(2, notice.getDate());
			stmt.setString(3, notice.getTitle());
			stmt.setString(4, notice.getDescription());
			stmt.setBoolean(5, notice.getStudent());
			stmt.setBoolean(6, notice.getAcademic());

			int i = stmt.executeUpdate();
			System.out.println("No. of records inserted" + i);

		} catch (ClassNotFoundException e) {
			System.out.println("1");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.print("2");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("3");
			e.printStackTrace();
		}
	}

	public static Notices[] getNotices(String userstate) throws ClassNotFoundException, SQLException, IOException {

		String SELECT_NOTICES = "";
		//SELECT_NOTICES = "select NID, date, title, description, student, academic from online_school_ims.notices";
		System.out.println(userstate);
		
		if (userstate.equals("student")) {
			SELECT_NOTICES = "select NID, date, title, description, student, academic from online_school_ims.notices where student = 1 ";
		} else if (userstate.equals("teacher")|| userstate.equals("admin")){
			SELECT_NOTICES = "select NID, date, title, description, student, academic from online_school_ims.notices where academic = 1 ";
		}

		Notices notices[] = new Notices[0];

		try {
			conn = DbConnection.getConnection();
			PreparedStatement statement = conn.prepareStatement(SELECT_NOTICES);

			ResultSet rs = statement.executeQuery();

			if (!rs.next()) {
				System.out.println("No Notices");
			} else {
				do {
					int NID;
					String date, title, description;
					boolean student, academic;

					NID = rs.getInt("NID");
					date = rs.getString("date");
					title = rs.getString("title");
					description = rs.getString("description");
					student = rs.getBoolean("academic");
					academic = rs.getBoolean("student");

					notices = Arrays.copyOf(notices, notices.length + 1);
					notices[notices.length - 1] = new Notices(NID, date, title, description, student, academic);

				} while (rs.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return notices;
	}
}
