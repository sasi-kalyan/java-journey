import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) {

        Path path = Path.of("logs//mypathfile.txt");

        System.out.println("file name: " + path.getFileName());
        System.out.println("file absolute path: " + path.getParent());
    }
}
