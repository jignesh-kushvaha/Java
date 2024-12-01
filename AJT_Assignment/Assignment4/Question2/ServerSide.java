package AJT_Assignment.Assignment4.Question2;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerSide {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.createRegistry(2000);
        BookServiceImpl bookImpl = new BookServiceImpl();
        rg.rebind("booksearch",bookImpl);
        System.out.println("Book Server is Running...");
    }
}
