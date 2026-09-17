public class SingletonExample {

    private static SingletonExample singletonObj ;

    public static synchronized SingletonExample getInstance() {
        if(singletonObj == null){
            singletonObj = new SingletonExample();
        }

       return singletonObj;
    }

    public static void main(String[] args) {

    }
}
