package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatThread extends Thread {
	private Socket s;
	private BufferedReader serverIn;
	private PrintWriter serverOut;
	private ChatServer server;
	private String username = null;
	
	// Initializes thread to communicate with specified socket
	public ChatThread(Socket s, ChatServer server) {
		this.s = s;
		this.server = server;
		try {
			serverIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
			serverOut = new PrintWriter(s.getOutputStream());
			
			do {
				username = serverIn.readLine();
			} while(username == null);
			
		} catch (IOException ioe) {
			System.out.println("IOE in ChatThread constructor: " + ioe.getMessage());
		}
	}

	// Sends an object over the network
	public void sendLine(String line) {
		serverOut.println(line);
		serverOut.flush();
	}
	
	// Get name
	public String getUsername() {
		return username;
	}

	public void run() {
		try {
			// Stay waiting for requests
			while (true) {
				String line = serverIn.readLine();
				
				// If we disconnect unexpectedly, don't send the line
				if(line == null) throw new IOException("Null line");
				
				server.sendMessageToClients(this,line);
			}
		}
		
		// Catch things
		catch (IOException ioe) {
			System.out.println(s.getInetAddress() + ":" + s.getPort() + " disconnected.");
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
