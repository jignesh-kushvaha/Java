package RMI;

import java.rmi.Naming;

public class ClientSide {
    public static void main(String[] args) {
        String answer,value="Jignesh";
        try{
            RemoteIF iri = (RemoteIF) Naming.lookup("rmi://localhost:2000/search");
            answer = iri.query(value);
            System.out.println("Answer = "+answer);

        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
