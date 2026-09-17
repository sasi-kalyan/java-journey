import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example3File {
    public static void main(String[] args) throws IOException {

        try(FileWriter fw = new FileWriter("logs\\naruto.txt")){
            fw.write("This is first line \nSecond Line");
        }catch (IOException e){
            System.out.println("Exception occurred");
        }

        try(FileReader fr = new FileReader("logs\\naruto.txt")){
            int j;
            while((j = fr.read()) != -1){
                System.out.print((char)j);
            }
        }
    }
}
