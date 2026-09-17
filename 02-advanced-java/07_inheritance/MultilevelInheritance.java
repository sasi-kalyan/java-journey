
//Multilevel Inheritance
class P{
    int a = 100;
}

class Q extends P{
    int b = 200;
}

class R extends Q{
    int c = 300;

    public void method(){
        System.out.println("A value: "+ a);
        System.out.println("B value: "+ b);
        System.out.println("C value: "+ c);
    }
}

public class MultilevelInheritance {
    public static void main(String[] args) {
        R obj = new R();
        obj.method();
    }
}
