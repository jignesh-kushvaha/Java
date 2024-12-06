package AJT_Assignment.Assignment3.Question2_B;
import org.omg.CORBA.TIMEOUT;

import java.io.*;
            import java.net.*;
            import java.util.Scanner;

public class ServerSide {
    private static final String FILE_PATH = "C:/Users/Jignesh/Desktop/server_file.txt";
    final static int SERVER_PORT = 5005;

    public static void main(String[] args) throws Exception{

        DatagramSocket socket = new DatagramSocket(SERVER_PORT);
        System.out.println("Enter text to write to the file:");
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String input = consoleReader.readLine();


        writeFile(input);
        System.out.println("File written: " + FILE_PATH);


        String fileContent = readFile();


        InetAddress clientAddress = InetAddress.getByName("127.0.0.1"); // Simulated client address
        int clientPort = 6000; // Client port
        sendData(socket, fileContent, clientAddress, clientPort);

        while (true) {
            System.out.println("Waiting for updated file content...");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);
            String updatedContent = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Updated file content received: " + updatedContent);

            writeFile(updatedContent);
            System.out.println("Updated content saved to " + FILE_PATH);
            break;
        }
    }

    private static void writeFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            writer.write(content);
        }
    }

    private static String readFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            return content.toString();
        }
    }

    private static void sendData(DatagramSocket socket, String data, InetAddress address, int port) throws IOException {
        byte[] buffer = data.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
        System.out.println("Sent data to " + address.getHostAddress() + ":" + port);
    }
}
