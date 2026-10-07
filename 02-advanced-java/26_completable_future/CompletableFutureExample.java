import java.util.concurrent.CompletableFuture;

/*
    CompletableFuture is an interface which is the enchanced versoin of the Future which support
    asychronous programming, task chaining, callback feature, composition and manual completion

    runAsync -> it is similar to Runnable, it will not accept any params, and give any result in return
    supplyAsync -> it is similar to Callable , it will return some result.

    Methods in completable future:
    runAsync()
    supplyAsync()
    thenApply()
    thenAccept()
    thenRun()
    thenCombine() - combines two completable futures into one
    allOf() - wait for all the tasks
    anyOf() - returns as soon as if anyone finishes
    exceptionally - for exception handling.
    handle() - that either handles the result or exception

 */

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


        CompletableFuture<Void> future2 = CompletableFuture.runAsync(()-> System.out.println("inside completable future 2"));
        future2.join();
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
