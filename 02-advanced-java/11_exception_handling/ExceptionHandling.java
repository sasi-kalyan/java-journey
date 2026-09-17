public class ExceptionHandling {

    /*

            Error: It refers to something goes wrong with the system, this is not under developer scope to handle.
            Exception: Is an unwanted event that interrupts the normal flow of the program is called exception. it halts the
            program execution and generates system generated message. Developer has the scope to handle this error.

            Exceptions are two types:
            1. Checked exceptions: exceptions throws at compile-time
            2. Unchecked exceptions: exceptions throws at runtime


            Heiraichy of Exception:

            Object
              |
            Throwable --->  Error: StackOverflowError, VirtualMachineError, OutOfMemeoryError
               |
            Exception ---> Checked Exceptions: SQLException, IOException, ClassNotFoundException, FileNotFoundException
               |
            Unchecked Exceptions: NullPointerExeption, ArithmeticException, IllegalArgumentation, ArrayIndexOutOfBounds etc...
     */

    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        //try block: the code which is has the possibility of throwing an exception, we usally keep that code segment inside the try block
        try{
            int c = a/b;

        }catch (ArithmeticException e){ //follwing the try block we have the catch block, it catches teh exception when the code the exception due to bad data entered by the user
            System.out.println("Arithmetic Exception Occurred...");
        }
    }
}
