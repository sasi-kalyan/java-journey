public class GenericExceptionHandlingExample {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 10;

        int[] arr = {1, 3, 5, 6};

        try{
            int result = num1/num2;           // if the num2 is zero the exception goes to the ArithmeticExecption block else Generic Block
            int getNum = arr[10];    // index not available it goes to the generic block
        }catch (ArithmeticException e){
            System.out.println("Cannot divide by zero!");
        }catch (Exception e){
            System.out.println("Some other exception occurred!" + e);
        }
    }
}

/*
    Some other exception occurred!java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 4
 */
