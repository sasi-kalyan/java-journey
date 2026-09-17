class Product extends Thread{
    String name;
    double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
        this.setName("Product-"+name);
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "added to cart "+price);

        try{
            if(name.equals("Pixel")){
                Thread.sleep(2000);
            }else if(name.equals("iPhone")){
                Thread.sleep(3000);
            }else{
                Thread.sleep(15000);
            }
        }catch (InterruptedException e){
            System.out.println("Product Ordering Interruped");
        }
    }
}

public class ProductOrder {
    public static void main(String[] args) {

        System.out.println("Store Opened...");
        Product product1 = new Product("Pixel", 40000.00);
        Product product2 = new Product("iPhone", 150000.00);
        Product product3 = new Product("OnePlus", 60000.00);

        System.out.println("Please wait in the lobby....");
        product1.start();
        product2.start();
        product3.start();

        System.out.println("Main Thread - Clearing Customer Queue....");
        try{
            product1.join();
            product2.join();
            product3.join();
        }catch (InterruptedException e){
            System.out.println("Product Ordering Interruped");
        }

        System.out.println("Product Ordering Completed...");
    }
}
