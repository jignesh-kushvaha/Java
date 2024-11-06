package Input_Output;
import java.io.*;
public class PipedInputOutputStreamEx {

    public static void main(String[] args) throws IOException,InterruptedException{

        PipedInputStream opis = new PipedInputStream();
        PipedOutputStream opos = new PipedOutputStream(opis);

        //Creating thread
        Thread writerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    opos.write("Piped Input Output Example".getBytes());
                    opos.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        Thread readerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    int data = 0;
                    while((data=opis.read()) != -1){
                        System.out.print((char) data);
                    }
                    opis.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        });

        //starting thread
        writerThread.start();
        readerThread.start();

        // wait until another thread completes its execution
        writerThread.join();
        readerThread.join();
    }
}
