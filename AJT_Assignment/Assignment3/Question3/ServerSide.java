package AJT_Assignment.Assignment3.Question3;

import java.io.*;
import java.net.*;

public class ServerSide {

    public static void main(String[] args) throws Exception {

        // Generate the AES encryption key
        Encryptor.generateKey();
        byte[] secretKey = Encryptor.getSecretKey();

        // Open a server socket
        ServerSocket serverSocket = new ServerSocket(2020);
        System.out.println("Server is running on port 2020...");

        try (Socket socket = serverSocket.accept()) {
            System.out.println("Client connected: " + socket.getInetAddress());

            // Send the AES key to the client
            ObjectOutputStream keyOut = new ObjectOutputStream(socket.getOutputStream());
//            keyOut.write(secretKey);
            keyOut.writeObject(secretKey);
            keyOut.flush();

            // Send encrypted file contents
            PrintWriter outSocket = new PrintWriter(socket.getOutputStream(), true);
            File file = new File("C:/Users/Jignesh/Desktop/server_file.txt");
            BufferedReader fileReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = fileReader.readLine()) != null) {
                String encryptedLine = Encryptor.encrypt(line);
                outSocket.println(encryptedLine);
            }

            // Close resources
            fileReader.close();
            socket.close();
            serverSocket.close();
            System.out.println("File sent successfully. Server closed.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
