
class E{
    int a = 100;
}

class F extends E{
    int b = 200;
}

class G extends E{
    int c = 300;
}

class H extends G{
    int d = 500;

    public void method(){
        System.out.println("A value: "+ a);
        System.out.println("C value: "+ c);
        System.out.println("D value: "+ d);
    }
}

public class HybridInheritance {
    public static void main(String[] args) {
        H obj = new H();
        obj.method();
    }
}
