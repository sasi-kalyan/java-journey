public class SingletonDP {

    /*
        Singleton Design Pattern:
        is the most popular creational design pattern which ensures that each class should have only one instance, it will
        act as the global access point for all.

        1. make the constructor private
        2. static method to return only one instance of the class.

        drawbacks:
            - it violates the single responsibility principle it controls its object creation and lifecycle.
            - it makes the unit testing complex, because the object components would be hard to mock.
            - through the reflections we can break the singleton behavior of the below code.
     */

    //volatile keyword ensures each thread would see the exact same content simultaneously.
    // i.e visibility across the threads
    private static volatile SingletonDP singleInstance;
    private static final SingletonDP INSTANCE = new SingletonDP();
    private static SingletonDP INSTANCE_1;

    private SingletonDP(){
        //private constructor
    }

    //another way creating the singleton object.
    public static SingletonDP getInstance2(){
        return INSTANCE;
    }


    //another way of creating the sinlgeton object
    public static SingletonDP getInstance3(){
        if (INSTANCE_1 == null){
            INSTANCE_1 = new SingletonDP();
        }

        return INSTANCE_1;
    }


    //this is the tread safe version of creating the singleton object
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

//        SingletonDP s1 = SingletonDP.getInstance();
//        SingletonDP s2 = SingletonDP.getInstance();

        SingletonDP s1 = SingletonDP.getInstance3();
        SingletonDP s2 = SingletonDP.getInstance3();

        System.out.println("s1 id: " + s1);
        System.out.println("s2 id: " + s2);
        System.out.println("is s1 == s2 ? " + (s1 == s2));
    }
}
