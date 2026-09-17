public class StringExample {
    /*
            String is an immutable object which cannot be modified , if we try to change
            it creates the new object in th heap.

            Key characteristics:
            - Immutable.
            - Thread safe since it is immutable.
            - Slower in performance.
     */

    public static void main(String[] args) {
        String str = "hello"; //string literal stores in String Constant Pool
        String obj = new String("Naruto!"); //literal stores in string pool and objects creates in HEAP.

        //String Methods

        System.out.println("length of the string: "+ str.length());

        //charAt method
        char c = str.charAt(0);
        char c2 = str.charAt(1);
        System.out.println("char at index 0: "+ c);
        System.out.println("char at index 1: "+ c2);

        //substring
        String sub = obj.substring(0, 2);
        System.out.println("substring 0..2: "+ sub);

        String p = "hello world";
        String psub = p.substring(5);
        System.out.println("substring 5 " + psub);

        //indexOf ; finds the first occurrence of char index in the string
        System.out.println("Index of o is: " + p.indexOf("o"));
        //lastIndexOf; finds the last occurrence of char index in the string
        System.out.println("last index of o is: " + p.lastIndexOf("o"));

        //equals method
        String a = "hello";
        String b = "hello";

        System.out.println(a.equals(b));
        System.out.println(a==b);

        System.out.println("Java".compareTo("Python"));

        //contains method
        System.out.println(a.contains("hello"));

        //toUpperCase, toLowercase
        System.out.println(a.toUpperCase());

        //replace
        String m = a.replace("hello", "java");
        System.out.println("replace : "+ m);

        //search methods
        System.out.println("Naruto in obj: "+ obj.indexOf("Naruto"));

        //comparsion methods
        System.out.println(str.equals(obj.toString()));
    }
}
