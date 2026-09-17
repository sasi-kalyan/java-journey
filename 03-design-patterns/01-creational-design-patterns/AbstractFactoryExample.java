interface IOS{
    void test();
}

interface Android{
    void test();
}

class IOSImpl implements IOS{

    @Override
    public void test() {
        System.out.println("Inside IOS Operating system...");
    }
}

class AndriodImpl implements Android{

    @Override
    public void test() {
        System.out.println("Inside Andriod operating system");
    }
}

class OS{
    public Object get(String osname) {
        if(osname.equals("IOS")) {
            return new IOSImpl();
        }

        return new AndriodImpl();
    }
}


public class AbstractFactoryExample {

    public static void main(String[] args) {
        OS os = new OS();
        Android android = (Android) os.get("ANDROIOD");
        android.test();
    }
}
