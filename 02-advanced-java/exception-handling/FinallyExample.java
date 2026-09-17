public class FinallyExample {
    /*
           Finally Block has special behaviour in the exception handling
           - Finally block always executes regardless of the exception occurred or not.
           - The block usually used for closing the connections or close resources which are opened
             like JDBC connections, ports, streams etc...
           - Without try block we cannot use finally , it is strongly associated with try, but finally is optional block in Eh.

           Special Behaviour:
           - Try block always executes even we have the return statement in the method.
           - The conditions where finally block doesn't execute is:
           1. If current Thread dies
           2. System.exit();
           3. Due to exception occurs in finally block.
     */

    public static int method(){
        try{
            return 100;
        }finally {
            System.out.println("finally block invoked...even we have the return statement");
        }
    }
    public static void main(String[] args) {
        method();
    }
}
