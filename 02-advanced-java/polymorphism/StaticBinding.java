class Super{
    static void method(){
        System.out.println("super static method");
    }
}

class Sub extends Super{
    static void method(){
        System.out.println("child static method");
    }
}

/*
        Static Binding:
        is also called as compile time binding or early binding , the method call to its method body
        resolves at compile time so it is static binding.
 */

public class StaticBinding {
    public static void main(String[] args) {
        Sub obj = new Sub();
        obj.method();   //sub class method has nothing to do with the super class method
    }
}
