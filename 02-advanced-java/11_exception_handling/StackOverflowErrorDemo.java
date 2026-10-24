import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class StackOverflowErrorDemo {

    //static int depth = 0;

    static int[] arr = new int[2_000_000_000];

    public static void recursive(){
        //depth++;
        recursive();
    }

    public static void main(String[] args) {
        //recursive();
    }
}
