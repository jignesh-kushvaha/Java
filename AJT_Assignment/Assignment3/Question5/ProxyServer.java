package AJT_Assignment.Assignment3.Question5;
import java.net.*;
import java.io.*;
public class ProxyServer {
    private static final int PORT = 2000;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Proxy Server started on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            // forward response back to the client.
            new Thread(() -> handleClientRequest(clientSocket)).start();
        }
    }

    private static void handleClientRequest(Socket clientSocket) {
        try (
                InputStream clientIn = clientSocket.getInputStream();
                OutputStream clientOut = clientSocket.getOutputStream()
        ) {

            // Read the request from the client
            byte[] buffer = new byte[4096];
            int bytesRead = clientIn.read(buffer);

            String request = new String(buffer, 0, bytesRead);
            System.out.println("Received request: " + request);

            // Forward the request to the actual server (:8080)
            Socket serverSocket = new Socket("localhost", 2002);
            OutputStream serverOut = serverSocket.getOutputStream();
            serverOut.write(buffer, 0, bytesRead);
            serverOut.flush();

            // Read the response from the server
            InputStream serverIn = serverSocket.getInputStream();
            while ((bytesRead = serverIn.read(buffer)) != -1) {
                clientOut.write(buffer, 0, bytesRead);
            }

            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
