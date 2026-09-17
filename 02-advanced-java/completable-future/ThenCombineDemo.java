import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThenCombineDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Current thread running the task is --> " + Thread.currentThread().getName());
                    return "Gon";
                }
        , executor).thenApply(fname -> fname.toUpperCase());

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Current thread running the task is --> " + Thread.currentThread().getName());
                    return "Ferreccs";
                }
                , executor).thenApply(lname -> lname.toUpperCase());

        CompletableFuture<String> result = future1.thenCombine(future2,
                (f, l) -> {
                    System.out.println("Inside combine method");
                    return "Full name: " + f + " " + l;
        });

        System.out.println("Final result --> " + result.join());
        executor.shutdown();

    }


}
