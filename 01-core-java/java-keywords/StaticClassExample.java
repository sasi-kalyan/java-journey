public class StaticClassExample {

    static class InnerClass{

        int id = 100;
        String data = "HelloWorld";

        void display(){
            System.out.println("InnerClass - Display() method");
        }
    }

    public static void main(String[] args) {
        StaticClassExample.InnerClass obj = new StaticClassExample.InnerClass();

        obj.display();
        System.out.println(obj.id+" "+obj.data);

    }
}
