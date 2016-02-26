package database;

import java.io.Serializable;
import java.util.ArrayList;

import model.kindling.User;

public class DatabaseRequest implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private final ArrayList<User> users = new ArrayList<User>();
	private final RequestType type;

	// Constructor
	public DatabaseRequest(User u, RequestType type) {
		users.add(u);
		this.type = type;
	}

	public User getUser() {
		return users.get(0);
	}
	
	public ArrayList<User> getListUsers() {
		return users;
	}

	public RequestType getRequestType() {
		return type;
	}
}