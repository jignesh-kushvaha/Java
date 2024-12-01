package AJT_Assignment.Assignment3.Question5;

public class ClientSide {
    public static void main(String[] args) {
        Internet internet = new ProxyServer();
        internet.connectTo("google.com");
        internet.connectTo("hotstar.com");
    }
}
