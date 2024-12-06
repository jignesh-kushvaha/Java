package AJT_Assignment.Assignment3.Question3;

import java.io.*;
import java.net.*;

public class ClientSide {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 2020)) {
            System.out.println("Connected to server.");

            // Receive the AES key from the server
            ObjectInputStream keyIn = new ObjectInputStream(socket.getInputStream());
            byte[] secretKey = (byte[]) keyIn.readObject();
            Encryptor.setSecretKey(secretKey);

            // Receive and decrypt file contents
            BufferedReader inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String encryptedLine;
            while ((encryptedLine = inSocket.readLine()) != null) {
                System.out.println(encryptedLine);
                String decryptedLine = Encryptor.decrypt(encryptedLine);
                System.out.println(decryptedLine);
            }

            // Close resources
            socket.close();
            System.out.println("File content received and decrypted successfully.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
