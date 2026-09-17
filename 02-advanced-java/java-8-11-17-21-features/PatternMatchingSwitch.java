public class PatternMatchingSwitch {

    public static void main(String[] args) {

        Object str = "hello";

        switch (str){
            case String s -> System.out.println("string object");
            case Integer i -> System.out.println("interger object");
            case Float f -> System.out.println("float object");
            default -> throw new IllegalStateException("Unexpected value: " + str);
        }

        int num = 17;

        switch (num%10){
            case 7 -> System.out.println("7 is output");
            default -> System.out.println("0 is output");
        }
    }
}
