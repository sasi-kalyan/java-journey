/*
    Constructor Chaining:
    It is the chaining process where the constructor of same class calls the other
    constructors which are exists inside it.

 */
public class ConstructorChaining {
    private int id;
    private String text;
    ConstructorChaining(){
        this(10);
        System.out.println("Constructor Chaining Process Starts...\nConstructor-1 Invoked");
    }
    ConstructorChaining(int id){
        this(10, "Hello World");
        System.out.println("Constructor-2 Invoked");
    }

    ConstructorChaining(int id, String text){
        this.id = id;
        this.text = text;
        System.out.println("Constructor-3 Invoked");
    }
    public static void main(String[] args) {
        ConstructorChaining obj = new ConstructorChaining();
    }
}
