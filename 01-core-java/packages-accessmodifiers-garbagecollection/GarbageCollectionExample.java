public class GarbageCollectionExample {

    public static void main(String[] args) {

        for(int i=0;i<=1000000000;i++){
            GarbageCollectionExample obj = new GarbageCollectionExample();
            obj = null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("garbage collected...");
    }
}
