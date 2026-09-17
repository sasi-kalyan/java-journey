public class MultipleStaticBlocks {
    static int age;
    static String name;

    static{
        age = 100;
        name = "xyz";
    }

    static{
        age = 1000;
        name = "Kalyan";
    }

    public static void main(String[] args) {
        System.out.println("Age: "+age);
        System.out.println("Kalyan: "+name);
    }
}
