public class ThreadLifeCycleDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Thread Life Cycle Demo....");

        Thread thread = new Thread(() -> {

            System.out.println("1. Thread State: "+ Thread.currentThread().getState());

            try{
                System.out.println("2. Going to Sleep...(TIMED_WAITING)");
                Thread.sleep(2000);

                System.out.println("3. Woke up! Doing some work...");

                synchronized (ThreadLifeCycleDemo.class){
                    System.out.println("4. Entered Synchronized Block...");
                    Thread.sleep(2000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("5. Thread completing...");
        });

        System.out.println("A. Before start() "+ thread.getState());

        thread.start();

        System.out.println("B. After start() "+ thread.getState());

        Thread.sleep(3000);

        System.out.println("C. After completion..."+ thread.getState());

    }
}
