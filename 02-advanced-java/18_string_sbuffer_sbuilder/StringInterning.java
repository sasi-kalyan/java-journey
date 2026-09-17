public class StringInterning {
    public static void main(String[] args) {

        String s1 = "Hello"; //added to string pool
        String s2 = "Hello"; //reuses the reference which is already there

        System.out.println(s1 == s2);

        String s3 = new String("Naruto");
        String s4 = s3.intern();

        System.out.println(s3 == s4); //its not equal, but contents are equal;
    }
}
