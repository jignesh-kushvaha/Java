package AJT_Assignment.Assignment4.Question1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientSide {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry("localhost",2000);
            FileReaderIF frIf = (FileReaderIF) registry.lookup("FileReaderImp");
            String filePath = "C:/Users/Jignesh/Desktop/mca_sem_3/Advance_Java/AJT_Assignment/Assignment4/Question1/sample.txt";
            String content = frIf.readFile(filePath);
            System.out.println("content : \n"+content);

        }catch(Exception ex){
            System.err.println("Client exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
