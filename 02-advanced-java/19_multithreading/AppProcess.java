import java.util.ConcurrentModificationException;

class Process extends Thread{
    private String processName;

    public Process(String processName) {
        this.processName = processName;
        this.setName("Process: " + processName);
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " is started running");

        try{
            if(Thread.currentThread().getName().equals("YOUTUBE")){
                System.out.println(Thread.currentThread().getName() + " is going to sleep for 2sec");
                Thread.sleep(10000);
            } else if (Thread.currentThread().getName().equals("SPOTIFY")) {
                System.out.println(Thread.currentThread().getName() + " is going to sleep for 4sec");
                Thread.sleep(5000);
            } else if (Thread.currentThread().getName().equals("INSTAGRAM")) {
                System.out.println(Thread.currentThread().getName() + " is going to sleep for 3sec");
                Thread.sleep(6000);
            } else {
                Thread.sleep(7000);
            }
        }catch (ConcurrentModificationException | InterruptedException e){
            System.out.println("Threads execution Interrupted!!!");
        }
    }
}


public class AppProcess {

    public static void main(String[] args) throws InterruptedException {

        Process youtube = new Process("YOUTUBE");
        Process spotify = new Process("SPOTIFY");
        Process instagram = new Process("INSTAGRAM");

        System.out.println("YOUTUBE APP IS GOING TO RUN....");
        youtube.start();
        System.out.println("SPOTIFY APP IS GOING TO RUN....");
        spotify.start();
        System.out.println("INSTAGRAM APP IS GOING TO RUN....");
        instagram.start();

        try {
            youtube.join();
            spotify.join();
            instagram.join();
        } finally {
            System.out.println("All processes started running...");
        }


    }
}
