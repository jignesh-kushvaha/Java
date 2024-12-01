package AJT_Assignment.Assignment4.Question3;

import java.rmi.registry.*;

public class SystemInfoServerSide {
    public static void main(String[] args) throws Exception{
        Registry rg = LocateRegistry.createRegistry(2000);
        SystemInfo SystemInfoImpl = new SystemInfoImpl();
        rg.rebind("systeminfo",SystemInfoImpl);
        System.out.println("System Server is running...");
    }
}
