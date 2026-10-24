
class Outer{
    private String message = "hello world";

    class Inner{

        public void printMsg(){
            System.out.println("message is: " + message);
        }
    }
}

class Outer1{

    static class Nested1{

        public void printMessage(){
            System.out.println("nested class (static)!!");
        }
    }
}

public class InnerClassExample {

    public static void main(String[] args) {

        new Outer1.Nested1().printMessage();

        Outer outer = new Outer();

        Outer.Inner inner = outer.new Inner();
        inner.printMsg();
    }
}
