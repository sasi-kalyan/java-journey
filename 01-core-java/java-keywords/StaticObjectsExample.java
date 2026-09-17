import java.sql.Statement;
import java.util.Stack;

public class StaticObjectsExample {

    private static int age = 100;
    private static String name = "XYZ";

    public static void main(String[] args) {
        StaticObjectsExample obj1 = new StaticObjectsExample();
        StaticObjectsExample obj2 = new StaticObjectsExample();

        System.out.println("Before Modification");
        System.out.println(obj1.age+" "+obj1.name);
        System.out.println(obj2.age+" "+obj2.name);

        obj1.age = 22;
        obj1.name = "Kalyan";

        System.out.println("After Modification");
        System.out.println(obj1.age+" "+obj1.name);
        System.out.println(obj2.age+" "+obj2.name);
    }
}
/*
all objects gets effected, if we change the static variables values using an object.
i.e the static memebers are shared among all the objects, if one object gets effected
all the objects have the similar impact.
*/

