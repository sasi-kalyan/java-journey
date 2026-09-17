import java.io.File;
import java.io.IOException;

public class ExampleFile {

    /*
        Java I/O is primarily used to handle the input output streams, where read the data from the source
        and write to the destinatino, the soruce/destination should be files, sockets, memory buffers etc...
        or may be other sources/sinks

        Java IO usually handles by the form of streams
        1. byte streams : like images, audio, video and other large collection of data
        2. characters streams: like strings, characters like that.
     */
    public static void main(String[] args) {

        //creation of file

        File file = new File("logs\\hello1.txt");

        try{
            if(file.createNewFile()){
                System.out.println("new file created...");
            }else{
                System.out.println("file already exists in the logs");
            }
        }catch (IOException e){
            System.out.println("error occurred!!");
        }

    }
}
