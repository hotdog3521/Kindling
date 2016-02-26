package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	// Port to connect with the server over
	public static final int PORT_NUMBER = 7777;
	
	// ServerSocket everything else connects to
	private ServerSocket chatSocket;
	private Vector<ChatThread> chats = new Vector<ChatThread>();
	
	// Constructor. Opens server socket then waits and accepts connections
	public ChatServer() {
		try {
			chatSocket = new ServerSocket(PORT_NUMBER);
			acceptConnections();
		}
		catch (IOException ioe) {
			System.out.println("IO Exception opening ServerSocket");
			System.out.println(ioe.getMessage());
		}
		// When we close down the server, close the ServerSocket
		finally {
			if (chatSocket != null) {
				try {
					chatSocket.close();
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
				s = chatSocket.accept();
				System.out.println("Client " + s.getInetAddress() + ":" + s.getPort() + " connected");
				ChatThread thread = new ChatThread(s,this);
				chats.add(thread);
				thread.start();
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception with ChatServer");
			System.out.println(ioe.getMessage());
		}
	}
	
	// Removes a chat thread
	public void removeChatThread(ChatThread ct) {
		chats.remove(ct);
	}
	public void sendMessageToClients(ChatThread sending, String str) {
		for (ChatThread ct : chats) {
			if(!ct.equals(sending)) {
				ct.sendLine(sending.getUsername() + ": " + str);
			}
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}

}