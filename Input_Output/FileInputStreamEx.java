package Input_Output;
import java.io.*;
//import java.io.FileInputStream;
//import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) throws IOException {
        
//        FileInputStream ofis = null;
//        //try{
//            ofis = new FileInputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample.txt");
//            int i = 0;
//            while((i=ofis.read()) != -1){
//                System.out.println("read " + (char)i + i);
//            }
//        //}catch(IOException e){
//         //   System.out.println("Error: " + e.getMessage());
//        //}finally{
//            if (ofis != null) {
//          //      try {
//                    ofis.close();
//            //    } catch (IOException e) {
//              //      System.out.println("Error closing stream: " + e.getMessage());
//              //  }
//            }
//       // }
        int size;
        File ofile = new File("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\sample.txt");
        FileInputStream ofis = new FileInputStream(ofile);

        int i = 0;
        while((i = ofis.read()) != -1){
            System.out.println(i + " read " + (char)i);
            System.out.println("Total Available Bytes: " + (size = ofis.available()));
        }

        if(ofis!=null){
            ofis.close();
        }
    }
}
