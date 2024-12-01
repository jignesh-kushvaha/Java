package AJT_Assignment.Assignment3.Question2.Chat_System_UDP;

import java.io.*;
import java.net.*;

public class ClientSide {
    public static void main(String[] args) throws IOException {
        DatagramSocket clientSocket;
        DatagramPacket sendPacket, receivePacket;

        clientSocket = new DatagramSocket();
        System.out.println("Client is online...");

        BufferedReader obr = new BufferedReader(new InputStreamReader(System.in));

        byte[] sendBuffer;
        byte[] receiveBuffer = new byte[1024];

        InetAddress serverAddress = InetAddress.getByName("localhost");

        String sendMsg;
        String receivedMsg;

        do {
            // Send message
            System.out.print("Send msg : ");
            sendMsg = obr.readLine();
            sendBuffer = sendMsg.getBytes();

            sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, 5555);
            clientSocket.send(sendPacket);
            System.out.println("Send successfully: ");

            // Receive reply
            receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
            receivedMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received msg : " + receivedMsg);

        } while (!sendMsg.equalsIgnoreCase("stop") && !receivedMsg.equalsIgnoreCase("stop"));

        clientSocket.close();
        System.out.println("Client stopped.");
    }
}
