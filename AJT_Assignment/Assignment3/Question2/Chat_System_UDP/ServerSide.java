package AJT_Assignment.Assignment3.Question2.Chat_System_UDP;

import java.io.*;
import java.net.*;

public class ServerSide {

    public static void main(String[] args) throws IOException {
        DatagramSocket serverSocket;
        DatagramPacket receivePacket, sendPacket;

        serverSocket = new DatagramSocket(5555);
        System.out.println("Server is online...");

        BufferedReader obr = new BufferedReader(new InputStreamReader(System.in));

        byte[] receiveBuffer = new byte[1024];
        byte[] sendBuffer;

        String receivedMsg;
        String sendMsg;

        do {
            // Receive message
            receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            serverSocket.receive(receivePacket);
            receivedMsg = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Received msg : " + receivedMsg);

            // Send reply
            System.out.print("Send msg : ");
            sendMsg = obr.readLine();
            sendBuffer = sendMsg.getBytes();

            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();

            sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
            System.out.println("Send msg Successfully : ");
        } while (!sendMsg.equalsIgnoreCase("stop") && !receivedMsg.equalsIgnoreCase("stop"));

        serverSocket.close();
        System.out.println("Server stopped.");
    }
}
