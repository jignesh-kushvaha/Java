package AJT_Assignment.Assignment3.Question5;
import java.net.*;
import java.io.*;
public class ClientSide {
    public static void main(String[] args) throws Exception{
        Socket s;
        OutputStream out;
        InputStream in;

        s = new Socket("127.0.0.1", 2000);

        // Connect to proxy
        out = s.getOutputStream();
        String request = "GET / HTTP/1.1\r\nHost: localhost\r\n\r\n";
        out.write(request.getBytes()); // Send an HTTP request through the proxy to the server
        out.flush();

        in = s.getInputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;

        // Read response from Proxy server
        while ((bytesRead = in.read(buffer)) != -1) {
            System.out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.close();
        s.close();
    }
}
