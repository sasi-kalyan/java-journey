## Encapsulation

Encapsulation is one of the fundamental concept of the object oriented programming. It is used for the data hiding, it binds the data members(variables) and methods into a single unit called class.

### What is encapsulation?
The whole idea behind encapsulation is to hide the implementation details from users. If a data member is private it means it can only be accessed within the same class. No outside class can access private data member (variable) of other class.

However if we setup public getter and setter methods to update (for example void setSSN(int ssn))and read (for example  int getSSN()) the private data fields then the outside class can access those private data fields via public methods.

This way data can only be accessed by public methods thus making the private fields and their implementation hidden for outside classes. That’s why encapsulation is known as data hiding. Lets see an example to understand this concept better.

### Key Concepts of Encapsulation in Java:
Private Variables: Instance variables of a class are marked as private to prevent direct access from outside the class.
Public Methods: Public getter and setter methods are provided to allow limited access to private variables.
Data Hiding: When we make the data private, we hide how the object’s details are stored and managed from outside the object. Only the methods of the class can directly change or use the data