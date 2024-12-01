package AJT_Assignment.Assignment3.Question5;

public class InternetServerImpl implements Internet{
    @Override
    public void connectTo(String host){
        System.out.println("Opened Connection to "+ host);
    }
}
