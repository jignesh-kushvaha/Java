package AJT_Assignment.Assignment3.Question4.Chat_System_TCP;

import java.io.*;
import java.net.*;

public class ClientSide {
    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream odis;
        DataOutputStream odos;
        System.out.println("start..");
        s = new Socket("localhost", 5555);
        System.out.println("Client is online...");

        odis = new DataInputStream(s.getInputStream());
        odos = new DataOutputStream(s.getOutputStream());
        BufferedReader obr = new BufferedReader(new InputStreamReader(System.in));

        String sendMsg;
        String receivedMsg;
        do {
            System.out.println();
            //send message
            System.out.print("Send msg : ");
            sendMsg = obr.readLine();
            odos.writeUTF(sendMsg);
            System.out.println("Send successfully: ");

            //receive message
            receivedMsg = odis.readUTF();
            System.out.println("Received msg : " + receivedMsg);

        } while ((!sendMsg.equalsIgnoreCase("stop")) && (!receivedMsg.equalsIgnoreCase("stop")));

        obr.close();
        odos.close();
        s.close();
    }
}
