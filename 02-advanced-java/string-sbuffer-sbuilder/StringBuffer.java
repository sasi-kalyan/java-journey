import java.nio.charset.Charset;

public class StringBuffer {
    /*
            String Buffer is mutable, thread-safe and all methods are synchronized
     */
    public static void main(String[] args) {

        java.lang.StringBuffer sb = new java.lang.StringBuffer();

        sb.append("hello");

        sb.setCharAt(0, 'C');

        System.out.println("capacity: "+ sb.capacity());

        sb.append("watching naruto a lot now a days");
        System.out.println("capacity: "+ sb.capacity());

        //insert
        sb.insert(1, "FIX");
        System.out.println("after insert: "+ sb);

        //delete
        sb.delete(1, 4);
        System.out.println("after delete: "+ sb);

        //deleteCharAt
        System.out.println("delete at 0: "+ sb.deleteCharAt(0));

        //reverse
        sb.reverse();
        System.out.println("after reverse: "+ sb);


    }
}
