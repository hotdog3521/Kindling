package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import model.kindling.Application;

/**
 * Created by tcai on 4/28/15.
 */
public class ChatReceiverThread extends Thread {
    public void run() {
        BufferedReader br = null;
        ArrayList<String> store = Application.getChatList();
        try {
            Socket s = Application.getChatSocket();
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while (true) {
                String line = br.readLine();
                if(line == null) throw new IOException("Received a null line from server");
                synchronized (store) {
                    store.add(line);
                }
            }
        } catch (IOException ioe) {
            System.out.println("IOE in ChatReceiverThread.run(): " + ioe.getMessage());
        }
        finally {
            if(br != null) try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
