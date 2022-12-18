package com.sims_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.sims_models.Auth;
import com.sims_util.DbConnection;

public class LoginDao {
	private static Connection con;
	private static final String FIND_USER = "select * from auth where userName = ? and password = ?";

    public static Auth validate(String userName, String password){
    	
        Auth user = null;

        //Validation
        try {
            con = DbConnection.getConnection();
            PreparedStatement stmt = con.prepareStatement(FIND_USER);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
            	int authId = rs.getInt("AUID");
                String name = rs.getString("userName");
                String pwd = rs.getString("password");
                String userState = rs.getString("userState");
                
                user = new Auth(authId, name, pwd, userState);

            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }


        return user;
    }
}
