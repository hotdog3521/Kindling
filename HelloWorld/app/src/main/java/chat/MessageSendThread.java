package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import model.kindling.Application;

/**
 * Created by tcai on 4/26/15.
 */

public class MessageSendThread extends Thread {
    private String message;
    public MessageSendThread(String line) {
        // Intitialize the variables to use
        message = line;
    }
    public void run() {
        PrintWriter pw = null;
        Socket s = Application.getChatSocket();
        try {
            pw = new PrintWriter(s.getOutputStream());
            pw.println(message);
            pw.flush();
        } catch (IOException ioe) {
            System.out.println("IOE in MessageSendThread constructor: " + ioe.getMessage());
            // Close the PrintWriter
            if (pw != null) {
                pw.close();
            }
        }
    }
}
