
class A{
    int a = 10;
    public void methodA(){
        System.out.println("A method");
    }
}

class B extends A{
    int b = 20;
    public void methodB(){
        System.out.println("B method");
    }
}

public class SingleInheritence{
    public static void main(String[] args) {
        B obj = new B();
        System.out.println("A value is : "+obj.a);
        System.out.println("B value is : "+obj.b);
        obj.methodA();
        obj.methodB();
    }
}