import java.io.*;
import java.net.*;

public class ServerSide {

    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream odis;
        DataOutputStream odos;

        ServerSocket ss = new ServerSocket(5555);
        s = ss.accept();
        odis = new DataInputStream(s.getInputStream());
        odos = new DataOutputStream(s.getOutputStream());

        int i;
        do {
            i = odis.read();
            System.out.println((char)(i + 1));
        } while ((char) i != 'q');

    }
}
