import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedWriterExample {
    public static void main(String[] args) {
        String buffer = "hello";
        String text = new String(buffer.getBytes(), StandardCharsets.UTF_8);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("logs\\fos.txt", true))) {
           bw.write("hello, there");
           bw.newLine();
           bw.write("Naruto: A story of Ninja...");
        } catch (IOException e) {
            System.out.println("Exception occurred!!");
        }

    }
}
