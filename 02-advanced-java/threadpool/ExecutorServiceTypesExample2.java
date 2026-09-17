import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
        ThreadPool: A pool is the team of available threads in the system, they perform the task individually
        once the task assigned to them is complete they pick up the next task as per their avaialbilty in the
        pool. The advantage of the thread pool is we can optimally compute the task without creating the new
        threads in the system (creating new thread each time can cause computation load on the system).
 */

public class ExecutorServiceTypesExample2 {
    public static void main(String[] args) {

        System.out.println("Excecutor Service Framework");

        //Fixed Thread Pool ; which is most common type of the thread pool
        /*ExecutorService fixedPool = Executors.newFixedThreadPool(3);

        for(int i=1;i<=5;i++){
            final int taskId = i;
            fixedPool.submit(()->{
                System.out.println("Task "+ taskId+" running on: "+ Thread.currentThread().getName());

                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Pool intterruped");
                }
            });
        }

        fixedPool.shutdown();

        //cached thread pool; grows dynamically if needed

        ExecutorService cachedPool = Executors.newCachedThreadPool();

        for(int i=1;i<=5;i++){
            final int id = i;
            cachedPool.submit(()->{
                System.out.println("Task "+id+" running on "+ Thread.currentThread().getName());

                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("cached pool interrupted");
                }
            });
        }
        cachedPool.shutdown();

        //3. Single Thread Executor
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        System.out.println("single thread executor....");
        for(int i=1;i<=5;i++){
            final int id = i;
            singleThread.submit(()->{
                System.out.println("Task "+id+" running on "+ Thread.currentThread().getName());

                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("cached pool interrupted");
                }
            });
        }
        singleThread.shutdown();*/

        //4. scheduled thread executor
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

        System.out.println("scheduled thread pool");

        scheduledThreadPool.schedule(()->{
            System.out.println("Scheduled Task Running");
        }, 2, TimeUnit.SECONDS);
    }
}
