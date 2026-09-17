import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutStreamExample {
    public static void main(String[] args) {

        String text = "Hi there, hello world!!";
        try(FileOutputStream fos = new FileOutputStream("logs\\fos.txt")){
            System.out.println(text.getBytes());
            fos.write(text.getBytes());
        }catch (IOException e){
            System.out.println("Exception occurred!!");
        }

    }
}
