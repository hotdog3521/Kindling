package database.sqlcommands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.kindling.Range;
import model.kindling.User;

public abstract class SQLCommand {
	protected static final String DRIVER = "com.mysql.jdbc.Driver";
	protected static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/";
	protected static final String DB_NAME = "bindling";
	protected static final String DB_USER = "root";
	protected static final String DB_PW = "kindling";

	protected void runQuery(String query) {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB_ADDRESS + DB_NAME, DB_USER, DB_PW);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			filterRS(rs);
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("CNFE: " + cnfe.getMessage());
		}
		catch (SQLException sqle) {
			System.out.println("SQLE: " + sqle.getMessage());
		}
	}
	
	protected void runUpdate(String update) {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB_ADDRESS + DB_NAME, DB_USER, DB_PW);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(update);
			
			stmt.close();
			conn.close();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("CNFE: " + cnfe.getMessage());
		}
		catch (SQLException sqle) {
			System.out.println("SQLE: " + sqle.getMessage());
		}
	}
	
	protected abstract void filterRS(ResultSet rs);
	
	public static User getUser(ResultSet rs) {
		try {
			// If there is no user, break
			User toReturn = new User(rs.getString("username"));
			toReturn.setPassword(rs.getString("password"));
			toReturn.setAge(rs.getInt("age"));
			toReturn.setIntelLevel(rs.getInt("intelligence"));
			toReturn.setSex(rs.getInt("gender"));
			toReturn.setSexualOrientation(rs.getInt("sexualOrientation"));
			
			int startIntel = rs.getInt("start_intel_pref");
			int finishIntel = rs.getInt("finish_intel_pref");
			Range intelRange = new Range(startIntel,finishIntel);
			int startAge = rs.getInt("age_pref_start");
			int finishAge = rs.getInt("age_pref_finish");
			Range ageRange = new Range(startAge,finishAge);
			
			toReturn.setAgeRange(ageRange);
			toReturn.setIntelRange(intelRange);
			
			return toReturn;
		} catch (SQLException sqle) {
			System.out.println("SQLE: " + sqle.getMessage());
			return null;
		}
	}
}
