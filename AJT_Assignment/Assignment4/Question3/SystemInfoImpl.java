package AJT_Assignment.Assignment4.Question3;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SystemInfoImpl extends UnicastRemoteObject implements SystemInfo {

    public SystemInfoImpl() throws RemoteException{
        super();
    }

    @Override
    public String getOSVersion() throws RemoteException {
        return "OS: " + System.getProperty("os.name") + ", Version: " + System.getProperty("os.version");
    }

    @Override
    public String getDiskInfo() throws RemoteException {
        File root = new File("/");
        long totalSpace = root.getTotalSpace();
        long freeSpace = root.getFreeSpace();

        return "Total Disk Space: " + totalSpace / (1024 * 1024 * 1024) + " GB, " +
               "Available Space: " + freeSpace / (1024 * 1024 * 1024) + " GB";
    }

    @Override
    public String getMemoryInfo() throws RemoteException {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        return "Total Memory: " + totalMemory / (1024 * 1024) + " MB, " +
                "Memory in Use: " + usedMemory / (1024 * 1024) + " MB";
    }
}
