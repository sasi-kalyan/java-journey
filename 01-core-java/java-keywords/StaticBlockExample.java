public class StaticBlockExample {
    static int age;
    static String name;

    static{
        age = 100;
        name = "Kalyan";
    }

    public static void main(String[] args) {
        System.out.println("Age: "+age);
        System.out.println("Name: "+name);
    }
}
