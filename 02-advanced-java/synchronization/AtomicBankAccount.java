import java.util.concurrent.atomic.AtomicInteger;

//SAFE BANK ACCOUNT - WITH SYNCHRONIZATION
public class AtomicBankAccount {
    private AtomicInteger balance = new AtomicInteger(1000);

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" is checking balance...");

        //check if enough balance in account
        while(true) {
            int currentBalance = balance.get();
            System.out.println(Thread.currentThread().getName()+" sees balance $"+currentBalance);

            if (currentBalance < amount){
                System.out.println(Thread.currentThread().getName()+" cannot withdraw $"+ amount+" Insufficient funds");
                return;
            }

            boolean success = balance.compareAndSet(currentBalance, currentBalance - amount);

            if(success){
                System.out.println(Thread.currentThread().getName()+" success withdraw $"+ amount+" New balance: $"+ balance.get());
                break;
            }else {
                System.out.println(Thread.currentThread().getName()+" failed to withdraw (someone doing operation)...retrying...");
            }
        }
    }

    public int getBalance(){
        return balance.get();
    }

    public static void main(String[] args) throws InterruptedException {

        AtomicBankAccount atomicBankAccount = new AtomicBankAccount();

        System.out.println("Initial balance: $"+ atomicBankAccount.getBalance());
        System.out.println("Two threads trying to withdraw amount...");

        Thread[] threads = new Thread[3];

        for(int i=0; i < 3; i++){
            int finalI = i;
            threads[i] = new Thread(()->{
                atomicBankAccount.withdraw(100+(finalI * 200));
            }, "Thread-"+(i+1));
        }

        for(Thread thread: threads){
            thread.start();
        }

        for(Thread thread: threads){
            thread.join();
        }

        System.out.println("Final balance in account $"+ atomicBankAccount.getBalance());
    }
}




