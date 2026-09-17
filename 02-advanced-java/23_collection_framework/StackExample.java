import java.util.Stack;

public class StackExample {
    /*
            Stack: Which extends the Vector
            It is LIFO (Last in First out) data structure
     */
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.addElement("naruto");
        stack.add("demon slayer");
        stack.push("hells paraise");

        System.out.println("stack data: "+ stack);

        //peek element
        System.out.println("peek element: "+ stack.peek());

        //pop the data
        System.out.println("after pop: "+ stack.pop());
        System.out.println("stack list: "+ stack);

        //isempty
        System.out.println("is empty? "+ stack.empty());
    }
}
