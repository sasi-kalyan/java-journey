//UNSAFE BANK ACCOUNT - WITHOUT SYNCHRONIZATION
public class UnsafeBankAccount {
    private int balance = 1000;

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" is checking balance...");

        //check if enough balance in account
        if(balance >= amount){
            System.out.println(Thread.currentThread().getName()+" can withdraw amount of $"+ amount);

            try{
                Thread.sleep(1000); //1sec
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            //actual withdraw
            balance = balance - amount;

            System.out.println(Thread.currentThread().getName()+" withdrew $"+ amount+" remaining balance: $"+ balance);
        }else{
            System.out.println(Thread.currentThread().getName()+" cannot withdraw amount since balance is low...");
        }
    }

    public int getBalance(){
        return balance;
    }

    public static void main(String[] args) throws InterruptedException {

        UnsafeBankAccount unsafeBankAccount = new UnsafeBankAccount();

        System.out.println("Initial balance: $"+ unsafeBankAccount.balance);
        System.out.println("Two threads trying to withdraw amount...");

        Thread thread1 = new Thread(()->{
            unsafeBankAccount.withdraw(800);
        }, "Thread1");

        Thread thread2 = new Thread(()->{
            unsafeBankAccount.withdraw(800);
        }, "Thread2");

        //concurrent withdraw
        thread1.start();
        thread2.start();


        thread1.join();
        thread2.join();

        System.out.println("Final balance in account $"+ unsafeBankAccount.getBalance());
    }
}
