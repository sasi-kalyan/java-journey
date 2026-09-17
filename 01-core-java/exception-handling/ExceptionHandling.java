
public class ExceptionHandling{

    public static void main(String[] args){

        int num1 = 10;
        int num2 = 0;

        int result = num1/num2;  //Exception: ArithmeticException

        /*
            Exception in thread "main" java.lang.ArithmeticException: / by zero
            at ExceptionHandling.main(ExceptionHandling.java:9)
        */

        System.out.println("Reuslt: " + result);
    }

}