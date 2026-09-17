

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
				wait();  //wait indefinetely
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
			restaurant.orderFood();
		}, "Customer");
		
		
		Thread chef = new Thread(() -> {
			restaurant.cookFood();
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