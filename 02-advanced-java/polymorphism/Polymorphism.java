
/*
        Polymorphism:
        It is the core principle of the OOPS defines that - we are allowed to declare a method
        in many different forms, we can perform a single action in many different ways.

        - it is the capacity of the method on which object it is acting upon.

        Types of Polymorphism:
        - Compile time/ Static - Example: Method overloading
        - Runtime / Dynamic - Example: Method overriding

        Binding:
        This the concept where the association of the method call to its method body is called binding.
 */

public class Polymorphism {
    public static void main(String[] args) {
        Car car = new Car();
        car.engineMethod();

        Engine engine = new Car(); //We have created the object actually to the class using parent reference
        engine.engineMethod();  //the association of method call (enginemethod) happens at runtime - dynamic binding
    }
}
