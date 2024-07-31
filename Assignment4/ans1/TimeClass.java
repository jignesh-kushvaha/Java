package Assignment4.ans1;

public class TimeClass {  
    public static void main(String[] args) {
        Timee t1 = new Timee(18,30,40);
        Timee t2 = new Timee(13,20,40);
        
        String difference = t1.timeLapsed(t2);
        
        System.out.println("Time difference: " + difference); 
    }    
}