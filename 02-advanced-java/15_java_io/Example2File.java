import java.io.*;

public class Example2File {
    public static void main(String[] args) throws IOException {

        Long t1 = System.currentTimeMillis();

        //writing data to the file
        try(FileOutputStream fos = new FileOutputStream("logs\\hello.bin")){
            String text = "Uzumaki Naruto, Hokage of Hidden Leave Village aka Konoha";
            fos.write(text.getBytes());
        } catch (IOException e) {
            System.out.println("error occurred.");
        }

        Long t2 = System.currentTimeMillis();

        //System.out.println("Difference between t1 and t2 (when FileOutputStream Completion) : " + (t2-t1));


        Long p1 = System.currentTimeMillis();

        //read data from file
        try(FileInputStream fis = new FileInputStream("logs\\hello.bin")){
            int i;
            while((i = fis.read()) != -1){
                System.out.print((char)i);
            }
        }

        Long p2 = System.currentTimeMillis();
        //System.out.println("Difference between p1 and p2 (when FileInputStream Completion) : " + (p2-p1));

        try(BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream("logs//bos.txt")
        )){
            String data = "Monster (Japanese)";
            bos.write(data.getBytes());
        }catch (
                IOException e
        ){
            System.out.println("io exception occurred");
        }

        BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("logs//bos.txt")
        );

        int d;
        System.out.println();

        while( (d = bis.read()) != -1){
            System.out.print((char) d);
        }

        Long k2 = System.currentTimeMillis();

        System.out.println("\nTotal time to complete the program in millisec: " + (k2-t1));
    }
}
