import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OutOfMemoryErrorExample {

    public static void main(String[] args) {

        List<double[]> list = new ArrayList<>();

        while (true){
            System.out.println("double[] array of size 1024^2 appended...");
            list.add(new double[1024 * 1024]); // actually double occupies 8 bytes of memory for each element.
        }
    }
}
