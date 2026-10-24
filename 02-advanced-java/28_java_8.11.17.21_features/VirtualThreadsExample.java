import java.time.Duration;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.concurrent.Executors;

public class VirtualThreadsExample {

    public static void main(String[] args) throws InterruptedException {

        Thread vt = Thread.ofVirtual().unstarted(
                () -> System.out.println("virtual thread started!!")
        );

        Thread vt2 = Thread.startVirtualThread(() -> System.out.println("somethign happening..."));

        // Running a MASSIVE number of concurrent tasks - something impossible with platform threads
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 100_000; i++) {
                int taskId = i;
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1)); // blocking call - but doesn't tie up an OS thread!
                    System.out.println("Task " + taskId + " done");
                    return null;
                });
            }
        } // executor.close() waits for all to finish

        vt.start();
        vt.join();


    }
}
