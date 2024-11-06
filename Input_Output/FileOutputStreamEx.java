package Input_Output;
import java.io.*;
public class FileOutputStreamEx {

    public static void main(String[] args) throws IOException{
        FileOutputStream ofos = new FileOutputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample.txt");
        ofos.write("jignesh".getBytes());
        System.out.print("Success...");
        ofos.close();
    }
}
