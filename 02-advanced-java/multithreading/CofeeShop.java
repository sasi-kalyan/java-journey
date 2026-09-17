import java.io.IOException;

class CoffeeMaker extends Thread{
    private String coffeeType;

    CoffeeMaker(String type){
        this.coffeeType = type;
        this.setName("Coffee Type : "+ type);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ "Starting to Make "+ coffeeType);

        try{
            if(coffeeType.equals("Espresso")){
                Thread.sleep(2000);
            }else if(coffeeType.equals("Cappuccino")){
                Thread.sleep(3000);
            }else{
                Thread.sleep(1500);
            }
        }catch (InterruptedException e){
            System.out.println("Coffee Making Interrupted");
        }

        System.out.println(Thread.currentThread().getName()+" is ready...");
    }
}


public class CofeeShop {
    public static void main(String[] args) {
        CoffeeMaker espresso = new CoffeeMaker("Espresso");
        CoffeeMaker cappuccino = new CoffeeMaker("Cappuccino");
        CoffeeMaker latte = new CoffeeMaker("Latte");

        System.out.println("Taking Orders....");

        //starting coffee making
        espresso.start();
        cappuccino.start();
        latte.start();

        System.out.println("Main thread: Processing payments and cleaning tables....");

        try{
            espresso.join();
            cappuccino.join();
            latte.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("All orders completed....");
    }
}
