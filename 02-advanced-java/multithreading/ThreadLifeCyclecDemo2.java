public class ThreadLifeCyclecDemo2 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Demonstrating Thread Life Cycle");

        Thread worker = new Thread(()->{
            System.out.println("1. Thread State in run(): "+ Thread.currentThread().getState());

            try{
                System.out.println("2. Going to Sleep for 2 Seconds (TIMED_WAITING)");
                Thread.sleep(2000);  //Moves to Timed Waiting State
                System.out.println("3. Woke up and moving further...");

                synchronized (ThreadLifeCyclecDemo2.class){
                    System.out.println("4. Entered Synchronized block");
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("5. Thread completed the execution...");
        });

        System.out.println("A. Before Start Thread State: "+ worker.getState());
        worker.start();
        Thread.sleep(100);

        System.out.println("B. After Thread Start , Thread state: "+ worker.getState());

        Thread.sleep(3000);
        System.out.println("C. After completion thread state: "+ worker.getState());

    }
}
