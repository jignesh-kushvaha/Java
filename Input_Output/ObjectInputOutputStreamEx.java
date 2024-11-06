package Input_Output;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ObjectInputOutputStreamEx {

    public static void main(String[] args) throws IOException,ClassNotFoundException{

        //writing data to file
        File ofile = new File("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\employee.dat");
        FileOutputStream ofos = new FileOutputStream(ofile);
        ObjectOutputStream oos = new ObjectOutputStream(ofos);

        // write single data
        /*Person op1 = new Person("jignesh",22);
        oos.writeObject(op1);
        */

        // write multiple data
        List<Person> p1 = new ArrayList<>();
        p1.add(new Person("Jignesh",22));
        p1.add(new Person("Sahil",23));
        p1.add(new Person("Piyush",24));

        for(Person p2 : p1){
            oos.writeObject(p2);
        }
        System.out.print("Successfully Written");

        //Reading data
        FileInputStream ofis = new FileInputStream("C:\\Users\\Jignesh\\Desktop\\mca_sem_3\\Advance_Java\\Input_Output\\employee.dat");
        ObjectInputStream ois = new ObjectInputStream(ofis);

        //For single data read
            //Person op2 = (Person) ois.readObject();
            //System.out.print(op2);

        //For multiple data reading
            while (true) {
                try {
                    Person person = (Person) ois.readObject();
                    System.out.println("Read object: " + person);
                } catch (IOException e) {
                    break; // End of file reached
                }
            }
    }
}

class Person implements Serializable{
    int age;
    String name;

    public Person(String name,int age){
        this.age = age;this.name=name;
    }

    @Override
    public String toString(){
        return "Person{name = '" + name + "', age = '" + age + "'}";
    }

}