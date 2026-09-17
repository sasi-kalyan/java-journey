

public class ThreadExample{
	
	public static void main(String[] args){
		
		Thread thread1 = new Thread(() -> {
			
			
			System.out.println("inside running thread..." + Thread.currentThread().getName()+ " " +Thread.currentThread().getState());
			
			System.out.println("thread is going to sleep for 2 sec...");
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("thread execution interuppted");
			}
		}, "THREAD1");
		
		System.out.println("Main thread execution started...");
		
		
		System.out.println("thread1 - is going to execute...");
		System.out.println("current state of the thread : " + thread1.getState());
		thread1.start();
		System.out.println("thread execution ended...");
	}
}