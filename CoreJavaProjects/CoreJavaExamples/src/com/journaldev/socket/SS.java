package com.journaldev.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.lang.Runnable;
import java.lang.Thread;
import java.net.ServerSocket;
import java.net.Socket;
 
public class SS {
    private ServerSocket server;
    private int port = 9876;
 
    public SS() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        SS example = new SS();
        example.handleConnection();
    }
 
    public void handleConnection() {
        System.out.println("Waiting for client message...");
 
        //
        // The server do a loop here to accept all connection initiated by the
        // client application.
        //
        while (true) {
            try {
                Socket socket = server.accept();
                new ConnectionHandler1(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 
class ConnectionHandler1 implements Runnable {
    private Socket socket;
 
    public ConnectionHandler1(Socket socket) {
        this.socket = socket;
 
        Thread t = new Thread(this);
        t.start();
    }
 
    public void run() {
        try
        {
            //
            // Read a message sent by client application
            //
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
 
            //
            // Send a response information to the client application
            //
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Hi...");
 
            ois.close();
            oos.close();
            socket.close();
 
            System.out.println("Waiting for client message...");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
