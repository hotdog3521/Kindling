package database.sqlcommands;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.kindling.User;

public class SignIn extends SQLCommand {
	private static String checkQuery = "SELECT * FROM users WHERE username='";
	private static String insert = "INSERT INTO users (gender, sexualOrientation,"
			+ "name,username, password, age, intelligence, start_intel_pref,"
			+ "finish_intel_pref, age_pref_start, age_pref_finish) VALUES (";
	
	private boolean hasResult;
	
	public boolean enrollUser(User u) {
		super.runQuery(checkQuery + u.getUserName() + "'");
		if(hasResult) return false;
		super.runUpdate(insert + u.getSex() + "," + u.getSexualOrientation() + ",'" +
			u.getName() + "','" + u.getUserName() + "','" + u.getPassword() + "'," + 
			u.getAge() + "," + u.getIntelLevel() + "," + u.getIntelRange().getStart() +
			"," + u.getIntelRange().getFinish() + "," + u.getAgeRange().getStart() + 
			"," + u.getAgeRange().getFinish() + ");");

		return true;
	}

	@Override
	protected void filterRS(ResultSet rs) {
		try {
			hasResult = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
