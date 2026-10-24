public class InterruptExample {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()){

                System.out.println("running..." + "interrupt flag = " + Thread.currentThread().isInterrupted());
                Thread.interrupted();
            }

            System.out.println("stopped." + " because interrupt flag = " + Thread.currentThread().isInterrupted());
        }, "worker_thread");


        thread.start();

        try{
            Thread.sleep(20);
        }catch (InterruptedException e){
            System.out.println("main thread exited due to exception");
        }

        thread.interrupt();
    }
}
