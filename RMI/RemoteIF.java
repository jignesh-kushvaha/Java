package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

//It will provide the description of the methods that can be invoked by remote clients.
public interface RemoteIF extends Remote {
    //Declared method prototype
    public String query(String str) throws RemoteException;
}
