import java.util.concurrent.*;

/*
        Callable is an interface representing a task that returns a result and may throw the checked
        exceptions
        the callable can be submitted via executor service.

        Future: is the interface which holds the result of the
         async computation result, which comes in future.
 */

class CallableClass implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 10;
    }
}

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CallableClass cc = new CallableClass();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future =  executorService.submit(cc);
        System.out.println(future.get());
    }
}
