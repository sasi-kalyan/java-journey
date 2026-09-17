public class StringBuilderExample {

    /*
        String Builder is identical to string buffer except that the methods are not synnchronized, so that it makes
        it faster in operations but it is not thread safe, use it in single threaded environments.
     */
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        System.out.println("initial capacity of string builder: " + sb.capacity());
        sb.append("HELLO WORLD");
        System.out.println("after appennd, capacity: " + sb.capacity());

        //charAt, setCharAt
        System.out.println("0 char in string: " + sb.charAt(0));
        sb.setCharAt(0, 'C');

        //insert
        sb.insert(1, "HELLO");
        System.out.println("after insert : " + sb);

        //delete(start, end), deleteCharAt(index)
        sb.delete(0, 1);
        sb.deleteCharAt(5);

        System.out.println("after delete character: " + sb);

        
    }
}
