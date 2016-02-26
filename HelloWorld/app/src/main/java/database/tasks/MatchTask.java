package database.tasks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import java.util.ArrayList;
import database.DatabaseRequest;
import database.RequestType;
import model.kindling.User;

/**
 * Created by winstojl on 4/26/15.
 */

public class MatchTask implements Runnable {
    private User sendU;
    private ArrayList<User> candidateSet = null;

    public MatchTask(User sendU) {
        this.sendU = sendU;
    }

    public ArrayList<User> getResult() {
        return candidateSet;
    }

    @Override
    public void run() {

        Socket s = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            s = new Socket("198.199.92.13", 8888);

            // Send the user over
            oos = new ObjectOutputStream(s.getOutputStream());
            DatabaseRequest request = new DatabaseRequest(sendU, RequestType.GET_MATCHES);
            oos.writeObject(request);
            oos.flush();

            // Read in the object we get back
            ois = new ObjectInputStream(s.getInputStream());
            DatabaseRequest req = (DatabaseRequest) ois.readObject();
            if (req == null) throw new IOException("Null returned");


            if (req.getRequestType() == RequestType.VALID) {
                candidateSet = req.getListUsers();
            }
        } catch (IOException ioe) {
            System.out.println("IOE: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("CNFE: " + cnfe.getMessage());
        } finally {
            try {
                if(oos != null) oos.close();
                if(ois != null) ois.close();
                if(s != null) s.close();
            } catch (IOException ioe) {
                System.out.println("IOE: " + ioe.getMessage());
            }

        }
    }
}
