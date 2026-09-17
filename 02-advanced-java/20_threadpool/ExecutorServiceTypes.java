import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTypes {
    public static void main(String[] args) {

        /*
        System.out.println("1. Fixed Thread Pool...");

        //1. FIXED THREAD POOL USING EXECUTORSERVICE
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        for(int i=1;i<=10;i++){
            final int t = i;
            fixedThreadPool.submit(()->{
                System.out.println("Task-"+t+" running by "+ Thread.currentThread().getName());

                try{
                    Thread.sleep(1000); //1sec
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        fixedThreadPool.shutdown();


        //2. CACHED THREAD POOL USING EXECUTOR SERVICE
        System.out.println("2. Cached Thread Pool");
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=1;i<=10;i++){
            final int t = i;
            cachedThreadPool.submit(()->{
                System.out.println("Task-"+t+" running by "+ Thread.currentThread().getName());

                try{
                    Thread.sleep(1000); //1sec
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
        cachedThreadPool.shutdown();



        //3. SINGLE THREAD POOL
        System.out.println("SINGLE THREAD POOL EXECUTOR");
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        for(int i=1;i<=10;i++) {
            final int t = i;
            singleThread.submit(() -> {
                System.out.println("Task-" + t + " running by " + Thread.currentThread().getName());

                try {
                    Thread.sleep(1000); //1sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        singleThread.shutdown();

         */

        //SCHEDULED THREAD POOL
        //after two seconds delay
        System.out.println("SCHEDULED THREAD POOL");
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        scheduledThreadPool.schedule(()->{
            System.out.println(" Scheduled Task Running after delay");
        }, 2, TimeUnit.SECONDS);

        //after 1seconds delay run every 3 seconds
        scheduledThreadPool.scheduleAtFixedRate(()->{
            System.out.println(" 1sec delay - scheduled taks running every 3seconds");
        }, 1, 3, TimeUnit.SECONDS);

        try{
            Thread.sleep(10000);//10secs
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        scheduledThreadPool.shutdown();
    }
}
