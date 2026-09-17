public class ConstructorExample {
    /*
        Constructor is a block of code that initializes the newly created object. Often developers looks the
        constructor as the special method since it resembles like method, apparently constructor is not a method
        it does not have any return type or not it will return any value.

        Different Types of Constructors:
        - default constructor
        - no-args constructor
        - parameterized constructor

        Note: If we do not include any constructor in the code, compiler automatically
        inserts the new constructor in the code.

        Quick Points:
        - Constructor name should exactly match with class name
        - Constructor should not be static, final, abstract and synchronized
        - Constructor does not contain any return types
        - Abstract classes can contain constructors but the constructor invokes only when
          the child class which extends the abstract class object created.
        - this, super keywords are the first statements in the constructor.
        - Constructor overloading is possible and constructor overriding is not possible.
     */

    private int id;
    private String text;

//    ConstructorExample(){
//        //default constructor
//    }

    ConstructorExample(){
        System.out.println("No-args/default constructor invoked");
    }

    ConstructorExample(int id, String text){
        this.id = id;
        this.text = text;
        System.out.println("Parameterized constructor invoked");
    }

    public static void main(String[] args) {
        ConstructorExample obj = new ConstructorExample(); //invokes no-arg/ default constructor
        ConstructorExample obj2 = new ConstructorExample(1, "Hello World"); //invokes parameterized constructor
    }
}
