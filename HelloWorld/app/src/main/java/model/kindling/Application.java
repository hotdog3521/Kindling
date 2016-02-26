package model.kindling;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import chat.ChatReceiverThread;
import chat.MessageSendThread;

/**
 * Created by Jay on 4/21/2015.
 */
public class Application {
    private static User _User;
    private static boolean loggedIn = false;
    private static Socket chatSocket;
    private static ArrayList<String> chatList = new ArrayList<>();

    public static void initApplication(User user) {
        //when we log in we give the application our user
        //and set loggedIn to true
        _User = user;
        loggedIn = true;

        openChatSocket();
        // Send in our username and wait for it to actually get sent
        Thread sendName = new MessageSendThread(_User.getUserName());
        sendName.start();
        try {
            sendName.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Open up receiving messages
        new ChatReceiverThread().start();
    }

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static User getUser() {
        return _User;
    }

    public static Socket getChatSocket() {
        return chatSocket;
    }

    public static ArrayList<String> getChatList() { return chatList; }

    public static void openChatSocket() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    chatSocket = new Socket("198.199.92.13", 7777);
                } catch (IOException ioe) {
                    System.out.println("IOE in openChatSocket(): " + ioe.getMessage());
                    try {
                        chatSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
