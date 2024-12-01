package AJT_Assignment.Assignment4.Question2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientSide {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.getRegistry("localhost",2000);
        System.out.println("Client is running...");
        BookService bookServiceIF = (BookService) rg.lookup("booksearch");

        int bookId = 2;
        String BookDetail = bookServiceIF.getBookDetail(bookId);
        System.out.println("Book Details:");
        System.out.print(BookDetail);
    }
}
