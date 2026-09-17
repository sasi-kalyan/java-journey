## Abstract Keyword

A class that is declared using a "abstract" keyword is a abstract class. the abstract class contains the abstract methods(non-concrete) and regular(concrete) methods.

Note: We cannot create an object to the abstract class, because these classes are incomplete.

### Rules of Abstract class
1. The child class must implement all the abstract methods, if we not it throws a compilation error.
2. Abstract class cannot be instantiated, i.e. we cannot create an object to the abstract class, because those classes are incomplete.
3. If the child class failed to implement all the abstract methods, we must declare the child class also abstract.

## Interfaces

Interfaces are used for the abstraction just like abstract keyword, but the interface provides full abstract while the abstract classes provides the partial abstraction.

### What are interfaces?

Interfaces are just like classes, but not a class. It can contains the methods (without body) and the methods are default public, abstract by default
and variables, are public, static, final by default.

### Tag or Marker Interface

An Empty Interface is known as the tag or maker interface.

### Nested interfaces
The interface which is declared inside another interface is called as nested interfaces.

### Key Points:
1. "implements" keywords are implement the interfaces.
2. we cannot create an object to the interface because, that is abstract.
3. the interface methods are public , abstract by default.
4. variables inside the interface are public, static, final by default.
5. Interface variables must initialized at the time of declaration.
6. A class can implement any number of interfaces
7. Variable name conflicts can be resolved by interface names.