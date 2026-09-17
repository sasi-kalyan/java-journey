import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//SAFE BANK ACCOUNT - WITH SYNCHRONIZATION
public class ModernBankAccount {
    private int balance = 1000;
    private Lock lock = new ReentrantLock();

    public synchronized void withdraw(int amount){
        //non-critical code so it can run concurrently
        System.out.println(Thread.currentThread().getName()+" is checking balance...acquiring lock shortly...");

        //check if enough balance in account
        lock.lock(); //acquire lock
        try {
            System.out.println(Thread.currentThread().getName() + "acquired lock...");
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + "can withdraw amount of $" + amount);

                try {
                    Thread.sleep(1000); //1sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //actual withdraw
                balance = balance - amount;

                System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + " remaining balance: $" + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " cannot withdraw amount since balance is low...");
            }
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" released lock");
        }

        //non-critical code so it can run concurrently
        System.out.println(Thread.currentThread().getName()+" Leaving bank...");
    }

    public int getBalance(){
        try{
            lock.lock();
            return balance;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ModernBankAccount modernBankAccount = new ModernBankAccount();

        System.out.println("Initial balance: $"+ modernBankAccount.balance);
        System.out.println("Four threads trying to withdraw amount...");

        Thread[] threads = new Thread[4];

        for(int i=0; i < 4; i++){
            int finalI = i;
            threads[i] = new Thread(()->{
                modernBankAccount.withdraw(100+(finalI * 200));
            }, "Thread-"+(i+1));
        }

        for(Thread thread: threads){
            thread.start();
        }

        for(Thread thread: threads){
            thread.join();
        }

        System.out.println("Final balance in account $"+ modernBankAccount.getBalance());
    }
}
