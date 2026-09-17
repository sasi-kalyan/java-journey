import java.io.File;
import java.io.IOException;

public class FileExample {
    /*
        File object is used to create a file, File object is from java.io package.
        createNewFile method is used to create new file

        There are many useful methods in File
        - createNewFile
        - delete
        - canRead
        - canWrite
        - exists
        - getName
        - getAbsolutePath
        - length
        - list
        - mkdir
     */
    public static void main(String[] args) {
        try{
            File file = new File("logs\\hello.txt");
            if(file.createNewFile()){
                System.out.println("File created successfully!!");
            }else{
                System.out.println("File already exists!!");
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred!!");
        }
    }
}
