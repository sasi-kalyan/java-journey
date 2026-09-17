public class ConstructorChaining {

    private int age;
    private String name;

    ConstructorChaining(){
        this(23);
    }

    ConstructorChaining(int age){
        this(age, "Kalyan");
    }

    ConstructorChaining(int age, String name){
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        ConstructorChaining obj = new ConstructorChaining();
        System.out.println(obj.age); //23
        System.out.println(obj.name); //Kalyan
    }
}
