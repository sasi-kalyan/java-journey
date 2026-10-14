import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonExample {

    private static SingletonExample singletonObj = null;

    private SingletonExample(){
    }

    public static synchronized SingletonExample getInstance() {
        if(singletonObj == null){
            singletonObj = new SingletonExample();
        }

       return singletonObj;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        SingletonExample singletonObj1 = getInstance();
        SingletonExample singletonObj2 = getInstance();

        System.out.println(singletonObj1 == singletonObj2);

        Constructor<SingletonExample> constructor = SingletonExample.class.getDeclaredConstructor();

        constructor.setAccessible(true);

        SingletonExample singletonObj3 = constructor.newInstance();

        System.out.println(singletonObj1 == singletonObj3);

    }
}
