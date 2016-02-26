package database;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.kindling.User;
import database.sqlcommands.AuthenticateUser;
import database.sqlcommands.SignIn;

public class DatabaseThread extends Thread {
	private Socket s;
	private ObjectInputStream serverIn;
	private ObjectOutputStream serverOut;
	
	// Initializes thread to communicate with specified socket
	public DatabaseThread(Socket s) {
		this.s = s;
		try {
			serverIn = new ObjectInputStream(s.getInputStream());
			serverOut = new ObjectOutputStream(s.getOutputStream());
		} catch (IOException ioe) {
			System.out.println("IOE in DatabaseThread constructor: " + ioe.getMessage());
		}
	}

	// Sends an object over the network
	public void sendObject(Object obj) {
		try {
			serverOut.writeObject(obj);
			serverOut.flush();
		} catch (IOException ioe) {
			System.out.println("IOE Sending Message: " + ioe.getMessage());
		}
	}

	public void run() {
		try {
			// Stay waiting for requests
			while (true) {
				DatabaseRequest request = (DatabaseRequest) serverIn.readObject();
				
				// If we disconnect unexpectedly, don't send the line
				if(request == null) throw new IOException("Null line");
				
				// Process request
				RequestType rt = request.getRequestType();
				User user = request.getUser();
				// TODO add code to do different things based on request type
				if(rt == RequestType.AUTHENTICATE_USER) {
					AuthenticateUser au = new AuthenticateUser();
					User returned = au.checkUser(user.getUserName(), user.getPassword());
					// If the user sent over exists and has the correct password, send valid
					if(returned != null)
						sendObject(new DatabaseRequest(returned, RequestType.VALID));
					// Otherwise invalid
					else
						sendObject(new DatabaseRequest(null,RequestType.INVALID));
				}
				else if (rt == RequestType.SIGN_IN) {
					SignIn sn = new SignIn();
					boolean success = sn.enrollUser(user);
					if(success)
						sendObject(new DatabaseRequest(null, RequestType.VALID));
					else
						sendObject(new DatabaseRequest(null, RequestType.INVALID));
				}
				else {
					sendObject(new DatabaseRequest(null,RequestType.INVALID));
				}
			}
		}
		
		// Catch things
		catch (IOException ioe) {
			System.out.println(s.getInetAddress() + ":" + s.getPort() + " disconnected.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("CNFE in reading request: " + cnfe.getMessage());
		}
		
		// Close readers, writers, socket
		finally {
			try {
				if(serverOut != null) serverOut.close();
				if(serverIn != null) serverIn.close();
				if (s != null) s.close();
			} catch (IOException ioe) {
				System.out.println("IOE closing Socket: " + ioe.getMessage());
			}
		}
	}
}
