package AJT_Assignment.Assignment4.Question3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SystemInfo extends Remote {
    String getOSVersion() throws RemoteException;
    String getDiskInfo() throws RemoteException;
    String getMemoryInfo() throws RemoteException;
}
