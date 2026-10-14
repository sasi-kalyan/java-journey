/*
        Static Keyword:
        - Static keyword can be used with variables, methods, and static blocks
        - If we are declaring a method, variable using static it means the segment belongs
        to the class level
        - Every object have shared access to the resources which are defined with static
 */


/*
    Static: is the keyword used by the variables, classes, and blocks - the static keyword in java
    represent the feilds, blocks or variables that belongs to the class rather specific object
    or instance.
 */

class QA{

    static void method(){
        System.out.println("this is QA method (parent static)");
    }
}

class RA extends QA{


    static void method(){
        System.out.println("this is RA method (child static");
    }
}

public class StaticExample {
    public static int val;

    static{
        val = 200;
    }

    //it overrides the data - because alternative static block
    static {
        val = 500;
    }

    //static method
    public static void method(){
        System.out.println("inside static method");
    }

    public static void main(String[] args) {

        QA qa = new RA();
        qa.method();

        StaticExample obj = new StaticExample();
        StaticExample obj1 = new StaticExample();

        obj.method();
        obj1.method();

        System.out.println("before value change:");
        System.out.println("obj: "+ obj.val+" obj1: "+ obj1.val);

        //changing data
        obj.val = 3000;
        System.out.println("after value change:");
        /*
            Both objects data got effected due to class level information
            loads only once and that data is same for all objects in heap.
         */
        System.out.println("obj: "+ obj.val+" obj1: "+ obj1.val);
    }

}
