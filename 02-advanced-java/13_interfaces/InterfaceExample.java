/*
        Interfaces:
        - Interfaces are used to achieve full abstraction
        - Interfaces are abstract contracts or blueprints, the classes which are implementing the
          interfaces must full-fill the contract defined inside the interfaces
        - In interfaces methods are public, abstract by default
        - The variables in the interfaces public, static, final by default
        - The variables should the initialized at the time of declaration
        - From Java-9, private methods are also possible
        - Java-8 : Interfaces can have default and static methods
        - interfaces should not declare as private, protected or transient
        - The empty interface is called as Tag or Marker Interface
        - We can achieve multiple inheritance using interfaces
        - Interfaces do not contain any constructors
 */

public interface InterfaceExample {
    int val = 100;  //public, static, final by
    void method2();  // public abstract by default
}
