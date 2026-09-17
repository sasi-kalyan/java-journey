## Method Overriding

Method overriding is an object-oriented programming feature, in which declaring the method in the subclass which is already present in the parent class/ super-class is called as method overriding. The child class can give its own implementation without impacting the parent class method.

### Advantages of the Method Overriding
The main advantage of the method overriding is to maintain the reusability of the code. The subclass can give its own implementation with the same signature of the method which is already defined in the super class.

### Rules of method overriding in Java
- Argument list: The argument list of overriding method (method of child class) must match the Overridden method(the method of parent class). The data types of the arguments and their sequence should exactly match.
- Access Modifier of the overriding method (method of subclass) cannot be more restrictive than the overridden method of parent class. For e.g. if the Access Modifier of parent class method is public then the overriding method (child class method ) cannot have private, protected and default Access modifier,because all of these three access modifiers are more restrictive than public.
- For e.g. This is not allowed as child class disp method is more restrictive(protected) than base class(public)

### Difference between Method Overloading and Method Overriding

1. Method overloading is the example of the static polymorphism and Method overriding is the example for the runtime polymorphism.
2. The binding of the overloaded method call to its definition happens at compile-time, while the binding of the overridden call to its definition happens at runtime.
3. Static methods can be overloaded, but the static methods cannot be overridden , even we perform the method overriding on the static methods, there is noting to do with the methods of parent and child class, both have no relation.
4. Performance: Method overloading gives the better performance than the method overriding.
5. Private and final methods can be overloaded, but not overridden.
6. Argument list should be different while doing method overloading. Argument list should be same in method Overriding.
7. In Java, when you override a method, the return type of the overriding method can be a subclass of the return type declared in the original method in the superclass. This is known as covariant return types.