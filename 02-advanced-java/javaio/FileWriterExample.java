import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try{
            FileWriter fw = new FileWriter("logs\\hello.txt");
            fw.write("Hello World!");
            fw.close();
        }catch (IOException e){
            System.out.println("Exception Occurred!!");
        }
    }
}
