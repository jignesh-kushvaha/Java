//. Write a TCP based program to read a file from another machine.

package AJT_Assignment.Assignment3.Question1;

import java.io.*;
import java.net.*;

public class  ClientSide {
    public static void main(String[] args) throws IOException {
        Socket s;
        InputStream ois;

        String serverAddress = "localhost";
        int port = 1234;

        // Client setup
        s = new Socket(serverAddress, port);
        System.out.println("Connected to the server!");


        ois = s.getInputStream();
        BufferedInputStream obis = new BufferedInputStream(ois);

        // Output stream to save the received file locally
        FileOutputStream ofos = new FileOutputStream("C:/Users/Jignesh/Desktop/receivedFile.txt");

        byte[] buffer = new byte[1024];  // Buffer for file transfer
        int bytesRead;

        // Read the file from the s and save it to the local system
        while ((bytesRead = obis.read(buffer)) != -1) {
            ofos.write(buffer, 0, bytesRead);
        }

        System.out.println("File received and saved successfully!");

        // Close all streams and the s
        ofos.close();
        obis.close();
        s.close();
    }
}

