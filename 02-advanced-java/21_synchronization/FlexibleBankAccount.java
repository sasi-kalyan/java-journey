//SAFE BANK ACCOUNT - WITHOUT SYNCHRONIZATION
public class FlexibleBankAccount {
    private int balance = 1000;

    private Object lock = new Object();

    public void withdraw(int amount){
        //non-critical code so it can run concurrently
        System.out.println(Thread.currentThread().getName()+" is checking balance...");

        //check if enough balance in account
        synchronized (lock) {
            if (balance >= amount) {
                System.out.println(Thread.currentThread().getName() + " can withdraw amount of $" + amount);

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

            //non-critical code so it can run concurrently
            System.out.println(Thread.currentThread().getName()+" Leaving bank...");
        }
    }

    public int getBalance(){
        synchronized (lock){
            return balance;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        FlexibleBankAccount flexibleBankAccount = new FlexibleBankAccount();

        System.out.println("Initial balance: $"+ flexibleBankAccount.balance);
        System.out.println("Three threads trying to withdraw amount...");

        Thread[] threads = new Thread[3];

        for(int i=0; i < 3; i++){
            int finalI = i;
            threads[i] = new Thread(()->{
                flexibleBankAccount.withdraw(100+(finalI * 200));
            }, "Thread-"+(i+1));
        }

        for(Thread thread: threads){
            thread.start();
        }

        for(Thread thread: threads){
            thread.join();
        }

        System.out.println("Final balance in account $"+ flexibleBankAccount.getBalance());
    }
}
