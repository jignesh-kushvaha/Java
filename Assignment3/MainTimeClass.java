package Assignment3;

class Second {
    private int second;

    public void setSecond(int second){
        this.second = second;
    }
    
    public int getSecond(){
        return second;
    }    
}
class Minute extends Second{
    private int minute;

    public void setMinute(int minute){
        this.minute = minute;
    }
    
    public int getMinute(){
        return minute;
    }

}

class Hour extends Minute{
    private int hour;
    
    public void setHour(int hour){
        this.hour = hour;
    }
    
    public int getHour(){
        return hour;
    }

}

class Timee extends Hour{
    public Timee(int Hours, int Minutes, int Seconds){
        setHour(Hours);
        setMinute(Minutes);
        setSecond(Seconds);
    }   

    public String timeLapsed(Timee x){
        int h = this.getHour() - x.getHour();
        int m = this.getMinute() - x.getMinute();
        int s = this.getSecond() - x.getSecond();
        return (h+":"+m+":"+s);
    }
}

public class MainTimeClass {
    public static void main(String[] args) {
        Timee t1 = new Timee(18,30,40);
        Timee t2 = new Timee(13,20,40);
        
        String difference = t1.timeLapsed(t2);
        
        System.out.println("Time difference: " + difference); 
    }
}
