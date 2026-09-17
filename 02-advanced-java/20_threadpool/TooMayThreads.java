public class TooMayThreads {
    public static void main(String[] args) {

        System.out.println("Creating multiple threads");

        for(int i=0; i <= 10; i++){
            final int p = i;
            Thread thread = new Thread(()->{
                System.out.println("Task-"+(p+1)+" running by Thread"+ Thread.currentThread().getName());
            }, "-"+String.valueOf(p));

            try{
                Thread.sleep(1000); //1sec
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            thread.start();
        }

    }
}
