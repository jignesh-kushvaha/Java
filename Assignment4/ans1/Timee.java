package Assignment4.ans1;

public class Timee extends Hour{
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
