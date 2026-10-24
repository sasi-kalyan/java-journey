import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Counter{
    private volatile int count = 0;

    private AtomicInteger acounter = new AtomicInteger(0);

    private static final Object lock = new Object();

    final ReentrantLock rlock = new ReentrantLock();

    public /*synchronized*/ void increment(){

        acounter.incrementAndGet();

        /*rlock.lock(); // acquire lock
        try{
            count++;
        }finally {
            rlock.unlock();
        }*/

//      count = count + 1;
        /*synchronized (lock) {
            count++;
        }*/
    }

    public int getCount(){
        //return count;
        return acounter.get();
    }
}

public class ClassicCounter {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        Runnable task = () -> {
            for(int i=0;i<100_000;i++){
                counter.increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getCount());
    }
}
