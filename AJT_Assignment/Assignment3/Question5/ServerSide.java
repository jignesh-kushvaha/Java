package AJT_Assignment.Assignment3.Question5;

import java.net.*;
import java.io.*;

public class ServerSide {
    private static final int PORT = 2002;

    public static void main(String[] args) throws IOException{
        Socket s;
        ServerSocket ss;

        ss= new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);
        while (true) {
            s = ss.accept();
            OutputStream out = s.getOutputStream();

            // Respond back with "Hello from the server!".
            String response = "HTTP/1.1 200 OK\r\n\r\nThis is Server";

            out.write(response.getBytes());
            out.flush();
            s.close();
        }
//        ss.close();
    }
}
