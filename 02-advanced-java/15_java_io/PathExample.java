import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathExample {

    public static void main(String[] args) throws IOException {

        File file = new File("logs//anime_file.txt");

        Path path = Path.of("logs//anime_file.txt");

        if(file.createNewFile()){
            System.out.println("file created successfully");
        }else{
            System.out.println("file already exists!!");
        }

        try(FileWriter fileWriter = new FileWriter("logs//anime_file.txt")){

            String animeInfo = "SPY X FAMILY is a great anime.\nNaruto is greates anime of all time.";
            fileWriter.write(animeInfo);
        }

        //============================================================================

        System.out.println("file name: " + path.getFileName());
        System.out.println("file absolute path: " + path.getParent());


        //to read all lines in one short.
        List<String> allLines = Files.readAllLines(path);
        allLines.stream().forEach(System.out::println);

        //readString -- one liner to read content in one short.

        String content = Files.readString(path);
        System.out.println(content);

        //writeString -- one liner to write data to file.

        Path path1 = Files.writeString(path, "Death Note is greates of all time as well.");

        System.out.println(path1.getFileName());

        String content1 = Files.readString(path1);
        System.out.println(content1);

    }
}
