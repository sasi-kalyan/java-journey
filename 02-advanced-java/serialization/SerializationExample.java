import java.io.*;

class Person implements Serializable {
    //2. Add serialVersionUID (optional but recommended)
    //this ensures that the sender and receiver would have the compatible classes
    private static final long serialVersionUID = 1L;

    //Fields
    private String name;
    private int age;

    //the fields which are marked as transient would not serializable
    private transient String password;

    //Constructor
    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        //Create person object
        Person person = new Person("kalyan", 23, "Hello@123");

        try{
            FileOutputStream fos = new FileOutputStream("logs\\per.ser");
            ObjectOutputStream objout = new ObjectOutputStream(fos);

            objout.writeObject(person);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
