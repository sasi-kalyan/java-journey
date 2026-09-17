import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {

        System.out.println("Main thread started execution: " + Thread.currentThread().getName());

        CompletableFuture<String> future = CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Fetched User from DB");

                    try {
                        sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    return "kalyan";
                }
        ).thenApply(
                (name) -> {
                    System.out.println("User name is going to transform in thenApply method");
                    return name.toUpperCase();
                }
        );

        CompletableFuture<Void> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside async --future-1");
            return 100;
        }).thenApply((i) -> {
            System.out.println("transforming the integer value --future-1");
            return i * 3;
        }).thenAccept(System.out::println);

        System.out.println("Main thread completed its execution, free to take up another task");
        String result = future.join();

        System.out.println("The final result : "  + result);
    }

    private static void sleep(int milli) throws InterruptedException {
        try{
            System.out.println("Thread is going into sleep mode: " + milli + " seconds");
            Thread.sleep(milli);
        }catch (InterruptedException e){
            System.out.println("Thread execution got interrupted!!");
        }
    }
}
