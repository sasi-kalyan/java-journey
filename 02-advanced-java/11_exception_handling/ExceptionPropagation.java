public class ExceptionPropagation {

    public static int method1(int a, int b){
        int res = method2(a, b);  //calling method2()
        return  res;
        //Here also exception not handled, so it propagates to calling method main()
    }

    public static int method2(int c, int d){
        int result = c /d;   //10/0 --- Zero Divided Error : Arithmetic Exception
        return result;
        // Exception not handled here so it propagates the calling method method1()
    }

    public static void main(String[] args) {
        //Handling the Exception
        try{
            method1(10, 0); // Method Calling - method1()
        }catch (ArithmeticException e){
            System.out.println("Exception Occurred!!");
        }
    }
}
