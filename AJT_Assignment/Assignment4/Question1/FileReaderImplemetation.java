package AJT_Assignment.Assignment4.Question1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class FileReaderImplemetation extends UnicastRemoteObject implements FileReaderIF {
    public FileReaderImplemetation() throws RemoteException {
        super();
    }

    @Override
    public String readFile(String filePath) throws RemoteException{
        StringBuilder content = new StringBuilder();

        try(BufferedReader bf = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = bf.readLine()) != null){
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            content.append("Error reading file: ").append(e.getMessage());
        }
        return content.toString();
    }
}
