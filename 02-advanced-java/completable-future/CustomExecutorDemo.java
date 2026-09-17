import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomExecutorDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture<String> future = CompletableFuture.supplyAsync( () ->
                {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println("Inside supply async...");
                    return "Hello World";
                }, executor).thenApply(n -> n.toUpperCase());

        String result = future.join();

        System.out.println("final result is: " + result);

        executor.shutdown();
    }
}
