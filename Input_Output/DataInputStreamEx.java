package Input_Output;
import java.io.*;

public class DataInputStreamEx {
    public static void main(String[] args) throws IOException {
        FileInputStream input = new FileInputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample.txt");

        DataInputStream inst = new DataInputStream(input);
        int count = input.available();
        byte[] ary = new byte[count];
        inst.read(ary);
//        inst.readFully(ary);
        for (byte bt : ary) {
            char k = (char) bt;
            System.out.print(k+"-");
        }
    }
}
