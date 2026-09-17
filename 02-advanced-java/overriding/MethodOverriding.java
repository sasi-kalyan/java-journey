
/*
        Method Overriding:
        - It is the concept where we can declare the method in the child class which is already
        present in the parent class.
        - The child class can give its own implementation without worrying about the parent class.

        Advantage:
        - It offers the reusability of the methods in the code.

        Note Points:
        1. The child class should have exact same method definition and parameters
        2. The access modifier of the child class overriding method should not be more restrictive than
        parent class overridden method
 */

class Parent{
    public void method(int val){
        System.out.println("inside parent class method; val="+val);
    }
}

class Child extends Parent{
    //the child class can give its own implementation
    @Override
    public void method(int val){
        super.method(100);  //we can call the parent class method using super keyword
        System.out.println("inside chiled class method; val="+val);
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Child child = new Child();
        child.method(200);
    }
}
