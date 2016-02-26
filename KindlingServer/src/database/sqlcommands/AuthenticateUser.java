package database.sqlcommands;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.kindling.User;

public class AuthenticateUser extends SQLCommand {
	private static String query = "SELECT * FROM users WHERE username='";

	private User toReturn = null;
	
	public User checkUser(String username, String password) {
		super.runQuery(query + username + "'");
		// Check for the correct password
		if(toReturn == null) return toReturn;
		if(!toReturn.getPassword().equals(password)) {
			System.out.println(toReturn.getPassword());
			return null;
		}
		return toReturn;
	}
	
	@Override
	protected void filterRS(ResultSet rs) {
		try {
			if(rs.next()) toReturn = getUser(rs);
		} catch(SQLException sqle) {
			System.out.println("SQLE: " + sqle.getMessage());
		}
	}

}
