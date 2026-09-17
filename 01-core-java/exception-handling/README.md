## Exeption Handling in Java

### What is an Exeption?
An Exception is the unwanted event which interrupts the normal flow of the program. The program
execution gets terminated when the exceptin raises.

### Importance of the Exeption Handling:
The execeptions are the runtime errors which interupts the flow of the code and throws a system 
genrated error message which is not user-friendly to understand to the devloper/user. so, we need
to handle them with the appropriate custom error message convinient to the developer/user.

### Why Exeption occurs?
There are particular scenarios where the exception causes the program termination, some of the 
frequent exceptions are:
1. ArithmeticExeption
2. NumberFormatExeption
3. NullPointerExeption
4. ArrayIndexOutOfBoundsExeption


### Exception Tree

Object <== Throwable <== Exception

- Checked Exceptions
  - IOException
  - SQLException
  - ClassNotFoundException
  - ClassDefNotFoundExeption
  - NoSuchMethodException

- RuntimeExeption 
  - ArrayIndexOutOfBoundsException 
  - ArithmeticException 
  - NullPointerException 
  - NumberFormatExeption


### Difference between Error and Exception:

### Error: 

Error indicates that something went wrong which is not in hands of the developer to handle. The errors might be a system failure, memroyleakage, or outofmemoryspace etc. like that.

### Exception: 
It indicates that something went wrong because a bad input provided by the user, which is not producing any issue at the compile time, but in runtime. So, to handle the runtime issues
we need to use the exception handling using try-catch blocks with appropriate exceptions.

### Types of Exeptions:

Exception are classified into two types, they are:
1. Checked Exceptions
   The exception which are handled at the compiler time, if we cannot handle program will not compiler or The exception which are not the runtime errors are called as the checked exceptions. these exceptions include:
   - SQLException
   - IOException
   - ClassNotFoundException
2. Unchecked Exceptions
   THe exceptions which occurs during the runtime are called as unchecked exceptions. these include
   - NullPointerException
   - ArithemeticException
   - NumberFormatException

### Try-Catch Blocks in Java:

The try-catch blocks are used in exception handling in java. The statements which are precisely identified as
exception throwing statements, those statements are placed inside the try block. The respective catch block is used
to catch the exception handling in the try block.

### Syntax of try-catch
`try{
//statements that may cause an exception
}catch(Exception e){
//statements that will execute when exception occurs
}`

### Syntax of try-finally
`try{
//statements that may cause an exception
}finally{
//statements that execute whether the exception occurs or not
}  `  

### Catch Block:

The catch block is the place where we are handling the exceptions throwed from the try block.
A single try block constains the atleast one associated catch block.

`try
{
//statements that may cause an exception
}
catch (exception(type) e(object))‏
{
//error handling code
}`

Note: A generic exception handler can handle all the exceptions but we should place the generic exception
at the end.


### Multiple Catch Blocks:

1. As we disucssed earlier, we can have multiple catch blocks for the single try block.
2. The generic exception block can handle any type of exception.
3. If not exception thrown in try block the catch blocks are completely ignored.

### Finally Keyword in ExceptionHandling

Finally keyword plays a very important role in exception handling. It is used to execute the important 
code such as closing the resources, regardless wheather the exception is thrown or not. So, the finally block
always executes.

### Syntax
`try {
// Code that may throw an exception
} catch (ExceptionType e) {
// Code to handle the exception
} finally {
// Code that will always execute
}`

### Importance of finally block

1. Resource Management: The finally block is responsible for closing the resources like files, database connections, network sockets to avoid resource leaks.
2. Execution Scenarios: Understand that the finally block always executes except in cases where the JVM exits during the try or catch blocks via calls like System.exit(), or in scenarios involving infinite loops or daemon threads.


### Throw Exception

We can have own set of conditions to throw an exception, we can do that using throw keyword, the syntax for the throw keyword as follows:

### Syntax 
`throw new exception_class("error message");
throw new ArithmeticException("dividing a number by 5 is not allowed in this program");`


### Creating Custom Exeptions

We can create our own user-defined exception or custom exceptions by extending the Exception class.
These are called custom exceptions in java.

Example:

`class Main extends Exception{
    Main(){
        //constructor
    }
}`


### Exception propagation 
It is a process by which compiler ensures that the exception is handled somewhere, if it is not handled where the exception occurs. For example, if main() method calls a method and that method (method1) is calling another method (method2). If the exception occurs in method2 and is not handled there then the exception is propagated to calling method method1 to see if it is handled there.

### Throws Keyword
The throws keyword is used to handle checked exceptions. As we learned in the previous article that exceptions are of two types: checked and unchecked. Checked exception (compile time) needs to be handled else the program won’t compile. On the other hand unchecked exception (Runtime) doesn’t get checked during compilation. Throws keyword is used for handling checked exceptions. You can declare multiple exceptions using throws keyword.

Generally, the trows keyword is used with the method signatures or declarations, that explains that the method can 
throw one or more exceptions. This informs the caller method to handle the exceptions either with try-catch block 
or propagate the exception to the further call stack.

Explanation
Purpose: To declare that a method can throw specific exceptions.
Usage: Placed in the method signature after the parameter list.
Effect: Forces the caller to handle the declared exceptions.