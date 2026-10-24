public class PatternMatchingSwitch {

    public static void main(String[] args) {

        Object str = "hello";

        Object obj = "this is string";

        Object num2 = 1;

        if(obj instanceof String){
            String str2 = (String) obj;
            System.out.println("obj is instance of the string, str - " + str2);
        }

        switch (num2){
            case String s -> System.out.println("string object");
            case Integer i when i < 10 -> System.out.println("interger object, less than 10");
            case Float f -> System.out.println("float object");
            default -> throw new IllegalStateException("Unexpected value: " + str);
        }

        int num = 17;

        switch (num%10){
            case 7 -> System.out.println("7 is output");
            default -> System.out.println("0 is output");
        }

        //String text blocks

        String json = """
                    {
                        "name": "kalyan",
                        "age": "INFINITE"
                    }
                """;
    }
}
