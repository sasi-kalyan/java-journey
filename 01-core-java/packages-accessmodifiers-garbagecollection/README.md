## Packages in Java

Packages are set of classes, interfaces or subpackages which are used to organize the java files according to their relation among them or similarity between them. We have two types of packages in java, they are:
1. Built-in packages
2. User defined packages 

### Advantages of using a package in Java
These are the reasons why you should use packages in Java:

- Reusability: While developing a project in java, we often feel that there are few things that we are writing again and again in our code. Using packages, you can create such things in form of classes inside a package and whenever you need to perform that same task, just import that package and use the class.
- Better Organization: Again, in large java projects where we have several hundreds of classes, it is always required to group the similar types of classes in a meaningful package name so that you can organize your project better and when you need something you can quickly locate it and use it, which improves the efficiency.
- Name Conflicts: We can define two classes with the same name in different packages so to avoid name collision, we can use packages.

## Access Modifiers

There are three in-built in java, incclude:
1. default
2. private
3. protected
4. public

### default access modifier

If we do not mention any modifier, it means it have default access, the scope the default access modifier is limited to the package.

### private access modifier

1. private data members and methods are only accessible to the class.
2. class and interfaces cannot be declared as private.
3. if a class has private constructor, we cannot create an object out side of the class.

### protected access modifier 
protected data member and method are only accessible by the classes of the same package and the subclasses present in any package. You can also say that the protected access modifier is similar to default access modifier with one exception that it has visibility in sub classes.

### Public access modifier
The members, methods and classes that are declared public can be accessed from anywhere. This modifier doesn’t put any restriction on the access.


## Garbage Collection

When the JVM starts up it creates the heap area which is know as the runtime data area. This is area we JVM need to manage this data area effectively, since the area is limited we need to frequetly clean up the memory which was occupied by the unwanted objects. The process of removing the unwanted objects from the heap memory is called garbage collection.
it is the part of memory management.

### How Garbage Collection works?

The garbage collection process involves teh series of steps;

1. Object creation: When we create an object it occupies the memory.
2. Reachability: An object is said to be reachable it is still have importance in the application, if it is not reachable it become eligible for the garbage collection.
3. Marking: The garbage collector identifies the reachable objects and unreachable object, it marks the unreachable objects for the deletion and remove the occuped memeory from the heap area.
4. Sweeping: The garbage collector release the memeory for the unreachable objects.
5. Compacation (Optional): Some garbage collectors also do compact memeory by moving the live objects closer to reduce fragementation.


### Generational Garbage collector:

Java uses the generational garbage collection strategy, which means it divides the heap memory into different regions based on the age of objects.

1. Young generation: newly created objects are allocated space here. it is divided into
    1. Eden space: Where new objects created.
   2. Survivor space: objects survive garbage collection in the eden space are moved here.
   Note: Garbage collection in eden space are called Minor GC.
2. Old Generation: Objects the survived from the multiple garbage cycle in the young generation are move here.
    Note: garbage collection in the Old generation are called Major GC or FUll GC.
3. Permenant Generation: Stores the metadata information about the classes and methods.

### Types of GC's:

1. Serial GC:
    1. Uses the single thread to perform the gc.
   2. Suitable for the single-threaded application or small heaps.
2. Parallel GC:
    1. Uses the multiple threads to perfrom gc.
   2. Suitable for multi-threaded environment and large heaps.
3. G1-GC(Garbage First GC)
4. ZGC
5. Shenandoah GC

### Key points about GC:
1. Developers do not need to manually free the memory.
2. The initialization of the gc is non-deterministic.
3. finalize method is the overridden method to perform the clean up when we want, but it is deprecated starting from Java 9.


