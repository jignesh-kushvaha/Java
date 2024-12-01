package AJT_Assignment.Assignment3.Question3;

import java.io.*;
import java.net.*;

public class ClientSide {
    final static int SERVER_PORT = 5005;
    final static int CLIENT_PORT = 6000; // Client's unique port number

    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket(CLIENT_PORT);
        // Wait for file content from the server
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("Waiting to receive file content...");
        socket.receive(packet);

        String fileContent = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received file content: " + fileContent);

        // Updating the file content
        System.out.println("Enter new content for the file:");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String updatedContent = consoleReader.readLine();

        // Send the updated file content back to server
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
        byte[] updatedBuffer = updatedContent.getBytes();
        DatagramPacket updatedPacket = new DatagramPacket(updatedBuffer, updatedBuffer.length, serverAddress, SERVER_PORT);
        socket.send(updatedPacket);
        System.out.println("Updated content sent to the server.");
    }
}


