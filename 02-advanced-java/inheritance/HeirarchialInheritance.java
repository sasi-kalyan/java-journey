//Heirarchial Inheritance
class M{
    int a = 100;
}

class N extends M{
    int b = 200;
    public void method(){
        System.out.println("A value: "+ a);
        System.out.println("B value: "+ b);
    }
}

class O extends M{
    int c = 300;

    public void method(){
        System.out.println("A value: "+ a);
        System.out.println("C value: "+ c);
    }
}

public class HeirarchialInheritance {
    public static void main(String[] args) {

        N obj1 = new N();
        obj1.method();

        O obj = new O();
        obj.method();
    }
}
