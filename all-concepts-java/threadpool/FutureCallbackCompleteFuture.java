import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallbackCompleteFuture{
	public static void main(String[] args){
		
		ExecutorService exe = Executors.newFixedThreadPool(4);
		
		Future<Integer> future = exe.submit(() -> {
			System.out.println("Thread submited, result already computed");
			
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println("thread interrupted...");
			}
			
			return 500;
		});
		
		
		System.out.println("Main thread still running...");
		
		try{
				Integer result = future.get();
				System.out.println("the result feteched from future -> " + result);
			}catch(Exception e){
				System.out.println("thread interrupted...");
			}
		
		
		exe.shutdown();
		
	}
}