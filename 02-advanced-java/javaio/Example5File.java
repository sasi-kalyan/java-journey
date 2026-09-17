import java.io.*;
import java.nio.charset.StandardCharsets;

public class Example5File {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(
                new FileInputStream("logs\\sample.txt"), StandardCharsets.UTF_8
        );

        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) !=null){
            System.out.println(line);
        }
    }
}
