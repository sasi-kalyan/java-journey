

class Restaurant{

	public volatile boolean foodReady = false;
	
	//Chef cooks food and notifies to customer (waiting)
	public synchronized void cookFood(){
		
		System.out.println(Thread.currentThread().getName() + " received the order list...");
		System.out.println("Preparing your order...");
	
		System.out.println("Food ready...updating order status");
		foodReady = true;
		notify();
	}
	
	public synchronized void orderFood(){
		System.out.println(Thread.currentThread().getName() + " Ordering food....");
		System.out.println("Complete ordering..., sending cooking request to chef...");
		
		if(!foodReady){
			try{
				wait();  //customer thread --> waits in-definitely
			}catch(Exception e){
			
			}	
		}
		
		System.out.println("Order received sucessfully...");
	}
	
}

public class WaitNotifyExample{

	public static void main(String[] args){
	
		Restaurant restaurant = new Restaurant();
		
		Thread customer = new Thread( () -> {
			restaurant.orderFood();   // customer thread wait() --> has been called, lock release on the object, and lock acquired by chef thread
		}, "Customer");
		
		
		Thread chef = new Thread(() -> {
			restaurant.cookFood();   // lock acquired --> once fishes, notify() is been called to continue the customer thread.
		}, "Chef");
		
		try{
			customer.start();
		}catch(Exception e){
			System.out.println("Problem with order");
		}
		
		
		try{
			Thread.sleep(2000); //main thread sleeping for 2 secs
		}catch(Exception e){
			System.out.println("Problem with order");
		}
		
		
		try{
			chef.start();
		}catch(Exception e){
			System.out.println("Problem with order");
		}
		
	}

}