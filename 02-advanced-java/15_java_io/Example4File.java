import java.io.*;

public class Example4File {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("logs\\hello.bin"));

        String line;
        while((line = bf.readLine()) != null){
            System.out.println(line);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("logs\\sample.txt"));
        bw.write("Today I have been watching Naruto again....");
        bw.newLine();
        bw.write("Probably i skip the episodes and continue with Naruto Shippuden");

    }
}
