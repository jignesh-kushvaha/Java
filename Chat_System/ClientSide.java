import java.io.*;
import java.net.*;

public class ClientSide {
    public static void main(String[] args) throws IOException {
        Socket s;
        DataInputStream odis;
        DataOutputStream odos;

        s = new Socket("localhost", 5555);
        odis = new DataInputStream(s.getInputStream());
        odos = new DataOutputStream(s.getOutputStream());
        BufferedReader obr = new BufferedReader(new InputStreamReader(System.in));

        int i;
        do {
            i = obr.read();
            odos.write((char) i);
        } while ((char) i != 'q');

        obr.close();

    }
}
