package AJT_Assignment.Assignment3.Question1;

import java.net.*;
import java.io.*;

public class ServerSide {
    public static void main(String[] args) throws IOException {
        ServerSocket ss;
        Socket s;
        FileInputStream ofis;
        OutputStream ofos;

        int port = 1234;
        ss = new ServerSocket(port);
        System.out.println("Server is waiting for a connection...");

        // Wait for client connection
        s = ss.accept();
        System.out.println("Client connected!");

        // Input stream to read the file
        ofis= new FileInputStream("C:/Users/Jignesh/Desktop/server_file.txt");  // File to be sent
        BufferedInputStream obis = new BufferedInputStream(ofis);

        // Output stream to send the file over the socket
        ofos = s.getOutputStream();

        byte[] buffer = new byte[1024];  // Buffer for file transfer
        int bytesRead;

        // Read the file and send it to the client
        while ((bytesRead = obis.read(buffer)) != -1) {
            ofos.write(buffer, 0, bytesRead);
        }

        System.out.println("File sent successfully!");

        // Close all streams and sockets
        obis.close();
        ofis.close();
        ofos.close();
        s.close();
        ss.close();
    }
}
