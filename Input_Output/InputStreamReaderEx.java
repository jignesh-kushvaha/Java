package Input_Output;
import java.io.*;

public class InputStreamReaderEx {
    public static void main(String[] args) {
        try  {
            FileOutputStream ofos = new FileOutputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample.txt",true);
            OutputStreamWriter oosr = new OutputStreamWriter(ofos);
            oosr.write("Kushvaha");
            oosr.close();
            ofos.close();


            FileInputStream stream = new FileInputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample.txt");
            InputStreamReader reader = new InputStreamReader(stream);
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}