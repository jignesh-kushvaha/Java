package Chat_System;

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

            System.out.print("Send msg : ");
            sendMsg = obr.readLine();
            odos.writeUTF(sendMsg);
            System.out.println("Send successfully: ");

            receivedMsg = odis.readUTF();
            System.out.println("Received msg : " + receivedMsg);

        } while (!sendMsg.equals("stop") || !receivedMsg.equals("stop"));

        obr.close();
        odos.close();
        s.close();
    }
}
