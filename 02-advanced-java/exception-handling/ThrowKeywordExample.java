public class ThrowKeywordExample {


    public static void method(int age){
        if(age < 18){
            throw new ArithmeticException("Age should be > 18");
        }
    }
    public static void main(String[] args) {

        /*
                Throw Keyword: In Java throw keyword is used to throw the exceptions if you have any custom conditions
                to apply on the logic so we can throw exceptions or we can also use throw to throw custom exceptions.
        */

        try{
            method(12);
        }catch (ArithmeticException e){
            System.out.println("Execption: "+ e.getMessage());
        }

    }
}
