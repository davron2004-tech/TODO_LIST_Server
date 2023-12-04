package Networking;

import frame.TodoListGUI;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader in;
    BufferedWriter out;
    TodoListGUI app;
    public Client(TodoListGUI app) {
        this.app = app;

    }
    public void sendMessage() {
        try {
            this.socket = new Socket("localhost", 8080);
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out.write("update table");
            out.newLine();
            out.flush();
            socket.close();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



