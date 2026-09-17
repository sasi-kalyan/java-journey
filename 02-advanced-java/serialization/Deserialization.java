import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("logs\\per.ser");

        ObjectInputStream ois = new ObjectInputStream(fis);

        Person person = (Person) ois.readObject();

        System.out.println(person.toString());
    }
}
