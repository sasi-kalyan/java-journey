## Static and Dynamic Binding

Binding: The Association of the method call with its method body is called binding. They are different types of binding it include.
1. Static Binding
2. Dynamic Binding

### Static Binding
- Static binding Happens at compile-time
- Method call of overloaded methods happens at compile-time
- The binding of static, final or private methods happens at compile time.

### Dynamic Binding
- Dynamic Binding Happens at runtime
- Methods call of the overridden methods happens at runtime.

### Static Binding vs Dynamic Binding
Lets discuss the difference between static and dynamic binding in Java.

Static binding happens at compile-time while dynamic binding happens at runtime.
Binding of private, static and final methods always happen at compile time since these methods cannot be overridden. When the method overriding is actually happening and the reference of parent type is assigned to the object of child class type then such binding is resolved during runtime.
The binding of overloaded methods is static and the binding of overridden methods is dynamic.



