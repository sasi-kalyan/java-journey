

public class ThreadExample{
	
	public static void main(String[] args){

		Thread thread = new Thread(() -> {

			System.out.println("Thread " + Thread.currentThread().getName() + " is under execution, current state: " + Thread.currentThread().getState());

			try{
				System.out.println("Thread " + Thread.currentThread().getName()+" is going to TIME_WAITING state");
				Thread.sleep(10);
				System.out.println("Thread " + Thread.currentThread().getName() + " state is: " + Thread.currentThread().getState());
			}catch (InterruptedException e){
				System.out.println("Thread terminated due to an exception");
			}

		}, "main_thread");


		System.out.println("Initial state of the thread " + Thread.currentThread().getName() + " -" + Thread.currentThread().getState());
		thread.start(); //starts the thread.
		thread.start();
		System.out.println("After thread completed execution, state: " + Thread.currentThread().getName()+" - "+ Thread.currentThread().getState());
	}
}