
/*
        Inheritance:
        It is the one of core principle of the OOPS defines that - a class can inherit its properties
        and behaviour of another class.

        Types of Inheritance
        - Single
        - Multilevel
        - Multiple (Not supports in JAVA)
        - Heirarcial
        - Hybrid form
 */

//Single Inheritance
class A{
    int a = 100;
}

class B extends A{
    int b = 200;

    public void method(){
        System.out.println("A value: "+ a+" B value: "+ b);
    }
}


public class InheritanceExample {
    public static void main(String[] args) {

        B b = new B();
        b.method();

    }
}
