package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementRemoteInterface extends UnicastRemoteObject implements RemoteIF{
    protected ImplementRemoteInterface() throws RemoteException {
        super();
    }

    @Override
    public String query(String str) throws RemoteException{
        if(str.equals("Jignesh")) return "Found "+str;
        else return "Not Found "+str;
    }
}
