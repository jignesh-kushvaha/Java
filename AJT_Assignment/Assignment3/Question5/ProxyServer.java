package AJT_Assignment.Assignment3.Question5;

import java.util.*;

public class ProxyServer implements Internet{
    private static final String bannedSites = "hotstar.com";
    private final Internet internet = new InternetServerImpl();


    @Override
    public void connectTo(String host){
        if(bannedSites.equals(host)){
            System.out.println("Access denied");
            return;
        }
        internet.connectTo(host);
    }
}
