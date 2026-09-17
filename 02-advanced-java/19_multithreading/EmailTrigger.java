
class EmailSender implements Runnable{
    private String recipient;
    private String message;

    EmailSender(String recipient, String message){
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "sending email to" + recipient);

        try{
            Thread.sleep((long)(Math.random()*2000));
        }catch (InterruptedException e){
            System.out.println("Email sending interrupted...");
        }
    }
}

public class EmailTrigger {
    public static void main(String[] args) {
        System.out.println("Email Trigger...");

        String[] recipients = {
                "kanakam.sasikalyan@example.com",
                "naruto.uzumaki@example.com",
                "monkey.d.luffy@example.com",
                "kamado.tanjiro@example.com"
        };

        Thread[] threads = new Thread[recipients.length];

        String message = "Dear Customer, We have special offer for you, subscribe for more updates!!";

        for(int i=0; i< recipients.length ; i++){
            EmailSender sender = new EmailSender(recipients[i], message);
            threads[i] = new Thread(sender, "Email Worker - "+(i+1));

            threads[i].start();
        }

        System.out.println("Main Thread: working...");

        for(Thread thread: threads){
            try{
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Email triggering completed...");
    }
}
