package AJT_Assignment.Assignment4.Question2;

import java.rmi.*;

public interface BookService extends Remote {
    public String getBookDetail(int id) throws RemoteException,Exception;
}
