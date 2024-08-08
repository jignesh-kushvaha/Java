package Input_Output;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamEx {
    public static void main(String[] args) throws IOException {
        byte[] byteData = "Jignesh Kushvaha".getBytes();

        //ByteArrayInputStream obais = new ByteArrayInputStream(byteData,2,5);  //take (byte array, offset, length)
        ByteArrayInputStream obais = new ByteArrayInputStream(byteData);

        int i = 0;
        while((i = obais.read()) != -1){
            System.out.print("  " +(char) i);
        }

        /*System.out.println();
        obais.reset();      // reset the pointer to starting of the file
        int j = 0;
        while((j = obais.read()) != -1){
            System.out.print("  " +(char) j);
        }*/

        obais.close();
    }
}
