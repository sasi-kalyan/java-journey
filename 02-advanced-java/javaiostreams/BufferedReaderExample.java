import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {
    public static void main(String[] args) {

        try(BufferedReader bf = new BufferedReader(new FileReader("logs\\fos.txt"))){
            String line = "";
            while((line = bf.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Exception occurred!!");
        }

    }
}
