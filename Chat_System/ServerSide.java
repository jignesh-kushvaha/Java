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
            receivedMsg = odis.readUTF();
            System.out.println(receivedMsg);

            sendMsg = obr.readLine();
            odos.writeUTF(sendMsg);
            System.out.println(sendMsg);

        } while (!receivedMsg.equals("stop"));

        odis.close();
        s.close();
        ss.close();
    }
}
