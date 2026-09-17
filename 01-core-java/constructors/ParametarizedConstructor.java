
public class ParametarizedConstructor{
    private int age;
    private String name;

    ParametarizedConstructor(int age, String name){
        this.age = age;
        this.name = name;
    }
    public static void main(String[] args){
        ParametarizedConstructor obj = new ParametarizedConstructor(23, "Kalyan");
        System.out.println(obj.age);
        System.out.println(obj.name);
    }
}