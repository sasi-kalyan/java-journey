public class SingletonDP {

    /*
        Singleton Design pattern: whcih ensures that each class should have only one instance, it will
        act as the global access point to the class resources.

        1. make the constructor private
        2. static method to return only one instance of the class.

        drawbacks:
            - it violates the single responsibility priciple it controls its object creation and lifecycle.
            - it makes the unit testing complex, because the object components would be hard to mock.
     */

    //volatile keyword ensures each thread would see the exact same content simultaneously.
    // i.e visibility across the threads
    private static volatile SingletonDP singleInstance;

    private SingletonDP(){
        //private constructor
    }

    public static synchronized SingletonDP getInstance(){

        if(singleInstance == null){

            synchronized (SingletonDP.class) {
                if(singleInstance == null) {
                    singleInstance = new SingletonDP();
                }
            }
        }

        return singleInstance;
    }

    public static void main(String[] args) {

        SingletonDP s1 = SingletonDP.getInstance();
        SingletonDP s2 = SingletonDP.getInstance();

        System.out.println("s1 id: " + s1);
        System.out.println("s2 id: " + s2);
        System.out.println("is s1 == s2 ? " + (s1 == s2));
    }
}
