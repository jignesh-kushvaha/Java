package AJT_Assignment.Assignment3.Question4.Chat_System_TCP;

import java.io.*;
import java.net.*;

public class ServerSide {

    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream odis;
        DataOutputStream odos;

        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Server is online...");

        s = ss.accept();
        System.out.println("Client is connected...");

        odis = new DataInputStream(s.getInputStream());
        odos = new DataOutputStream(s.getOutputStream());
        BufferedReader obr = new BufferedReader(new InputStreamReader(System.in));

        String receivedMsg;
        String sendMsg;
        do {
            //Receive message
            System.out.println();
            receivedMsg = odis.readUTF();
            System.out.println("Received msg : " + receivedMsg);

            //send message
            System.out.print("Send msg : ");
            sendMsg = obr.readLine();
            odos.writeUTF(sendMsg);
            System.out.println("Send msg Successfully : ");
        } while (!sendMsg.equalsIgnoreCase("stop") && !receivedMsg.equalsIgnoreCase("stop"));

        odis.close();
        s.close();
        ss.close();
    }
}
