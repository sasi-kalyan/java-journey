import java.util.Arrays;

public class MainMethod {

    /*
        the main method should always be public static - if we don't mention
        the JVM is not able to find the Entry point of the Java Program eventually
        leads to error.

        static refers to the class-level information we are notifying the JVM since the
        main method is static this is your entry point to the program to progress further
        tasks.

        Main method can be final also, program will run without any error.
     */

    //we can achive the alternative way to define main method without having static
    public void main(int[] args){
        Arrays.stream(args).forEach(System.out::print);
    }

    public static void main(String[] args) {
        MainMethod obj = new MainMethod();
        obj.main(args);
    }
}
