import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example2File {
    public static void main(String[] args) throws IOException {

        //writing data to the file
        try(FileOutputStream fos = new FileOutputStream("logs\\hello.bin")){
            String text = "Uzumaki Naruto";
            fos.write(text.getBytes());
        } catch (IOException e) {
            System.out.println("error occurred.");
        }

        //read data from file
        try(FileInputStream fis = new FileInputStream("logs\\hello.bin")){
            int i;
            while((i = fis.read()) != -1){
                System.out.print((char)i);
            }
        }
    }
}
