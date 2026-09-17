/*
        Abstract Class:
        - The class which is declared with the abstract keyword is an abstract class.
        - We cannot instantiate the abstract classes because they are incomplete
        - abstract classes contain both abstract methods and non-abstract(regular) methods
        - if class extends the abstract class, the abstract class enforces all the subclasses
          to implement the all the abstract class methods: must rule to follow.
        - if subclasses do not want to implement all the methods we can make the subclass also abstract
        - abstract classes can contain constructors , the constructors would invoke only when the object of
          child class which extending the abstract class created.
        - Abstract classes provides ==> partial abstraction
 */

abstract class AClass{

    AClass(){
        System.out.println("abstract class constructor invoked...");
    }

    public abstract void method1();
    public abstract int method2();
    void method3(){
        System.out.println("normal method");
    }
}

class BClass extends AClass{
    //If we donot implement all the methods in the class it throws error/ make abstract


    @Override
    public void method1() {
        System.out.println("method1 implemented");
    }

    @Override
    public int method2() {
        return 0;
    }
}



public class AbstractExample {
    public static void main(String[] args) {
        BClass obj = new BClass();
        obj.method1();
        obj.method2();
        obj.method3();
    }
}
