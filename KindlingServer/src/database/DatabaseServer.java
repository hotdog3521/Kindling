package database;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DatabaseServer {
	// Port to connect with the server over
	public static final int PORT_NUMBER = 8888;
	
	// ServerSocket everything else connects to
	private ServerSocket dbSocket;
	
	// Constructor. Opens server socket then waits and accepts connections
	public DatabaseServer() {
		try {
			dbSocket = new ServerSocket(PORT_NUMBER);
			acceptConnections();
		}
		catch (IOException ioe) {
			System.out.println("IO Exception opening ServerSocket");
			System.out.println(ioe.getMessage());
		}
		// When we close down the server, close the ServerSocket
		finally {
			if (dbSocket != null) {
				try {
					dbSocket.close();
				} catch (IOException ioe) {
					System.out.println("IOE closing ServerSocket: " + ioe.getMessage());
				}
			}
		}
	}
	
	// Has the server sit and wait for connections to accept.
	// Upon accepting a connection, start a database thread
	private void acceptConnections() {
		Socket s = null;
		try {
			while (true) {
				s = dbSocket.accept();
				System.out.println("Client " + s.getInetAddress() + ":" + s.getPort() + " connected");
				DatabaseThread thread = new DatabaseThread(s);
				thread.start();
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception with DBServer");
			System.out.println(ioe.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new DatabaseServer();
	}
}
