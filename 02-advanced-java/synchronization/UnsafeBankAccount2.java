class BankAccount2{
    private int credit = 1000;

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName() + "is checking balance");

        if(credit >= amount){
            System.out.println(Thread.currentThread().getName()+"ready to withdraw amount of: "+ amount);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println(Thread.currentThread().getName()+" withdraw interrupted");
            }

            credit -= amount;
            System.out.println(amount + "- Amount debited by - "+ Thread.currentThread().getName()+"New credit: "+ credit);
        }else{
            System.out.println(Thread.currentThread().getName()+" cannot withdraw insufficient funds; " +
                    "credit is: "+ credit);
        }
    }

    public int getCredit() {
        return credit;
    }
}


public class UnsafeBankAccount2 {
    public static void main(String[] args) {
        BankAccount2 bankAccount2 = new BankAccount2();
        System.out.println("initial credit: "+ bankAccount2.getCredit());

        System.out.println("Friend1, Friend2 is Trying to Debit 800");

        Thread t1 = new Thread(()->{
            bankAccount2.withdraw(800);
        }, "friend-1");

        Thread t2 = new Thread(()->{
            bankAccount2.withdraw(800);
        }, "friend-2");

        System.out.println("Trying to debit...");
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            System.out.println("interrupted...");
        }

        System.out.println("current credit: "+ bankAccount2.getCredit());
    }
}
