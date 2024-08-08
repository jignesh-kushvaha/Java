package Input_Output;
import java.io.*;
public class SequenceInputStreamEx {
    public static void main(String[] args) throws IOException,ClassNotFoundException,InterruptedException{

        FileInputStream ofis1 = new FileInputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample.txt");
        FileInputStream ofis2 = new FileInputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample1.txt");

        SequenceInputStream osis = new SequenceInputStream(ofis2,ofis1);
        int i = 0;
        while((i = osis.read()) !=-1){
            System.out.print((char) i);
        }

        osis.close();
        ofis2.close();
        ofis1.close();
    }
}
