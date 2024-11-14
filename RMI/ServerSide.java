package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerSide {
    public static void main(String[] args) {
        try{
        // Create an object of the interface implementation class
            ImplementRemoteInterface iri = new ImplementRemoteInterface();

        // rmiregistry within the server JVM with; port number 2000
            Registry registry = LocateRegistry.createRegistry(2000);

        // Binds the remote object by the name
            registry.rebind("search",iri);

            System.out.println("Server Started...");

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
