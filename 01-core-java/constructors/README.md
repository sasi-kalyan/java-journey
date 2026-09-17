## Constructors in Java
Constructor is the block of code that initalizes the newly created object. It resembles like a method but it is not method, it doesn't have any return type. Developers prefer the consturctor is the special method.

### Types of constructors:
In java there are 3 types of constructors classified, they include
- Default constructor
- No-arg constructor
- Parametarized constructor

### Constructor Chaining

Constructor chaining is the process of calling the constructors of the same class.

Note: this, super keywords are the first statements in the constructor.

### Copy Constructor

Copy constructor - copying the values of the one constructor to another consturctor. Java doesn't have concept of 
copy of constuctor like in c++. but, we can make in happen using in different ways
1. By creating a parameterized constructor
2. By using clone() method
3. By assigning the values of one object to another object.

### Quick Recap

1. Every class contains constructor whether it's nornal class or abstrct class
2. Constructors are not methods and they donot have any return type.
3. Constructor name should match with the class name.
4. Constructors can use any type of access specifier, it can be declared as private also, but the scope is within the class only.
5. If we do not implement the constructor compiler will do it.
6. this and super keywords are the first statements inside the constructor.
7. Constructor overloading is possible not overriding.
8. Constructors cannot be inherited.
9. Interfaces donot contains constructors.
10. Abstract class can have constructors but it is invoked when the class instantiated.
11. Constructor of the same class can call the other constructors of the same class - constructor chaining
12. Constructors cannot be abstract, final, static and synchronized , but methods can be.