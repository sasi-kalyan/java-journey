public class ConstructorOverloading {

    /*
        Constructor overloading is invoking different constructors of the same class
        the constructors differed in parameters.
        The difference in parameters would be:
        - in number of parameters
        - data type of params
        - sequence of params
     */

    private int id;
    private double val;
    private String text;

    ConstructorOverloading(){
        System.out.println("Default constructor");
    }

    //Constructor have only one parameter
    ConstructorOverloading(int id){
        this.id = id;
        System.out.println("Id value: "+ id);
    }

    //constructor has different number of parameters.
    ConstructorOverloading(double val, String text){
        this.val = val;
        this.text = text;
        System.out.println("Val: "+ val+" Text: "+ text);
    }

    public static void main(String[] args) {
        ConstructorOverloading obj = new ConstructorOverloading();
        ConstructorOverloading obj1 = new ConstructorOverloading(10);
        ConstructorOverloading obj3 = new ConstructorOverloading(100, "Hello World");
    }
}
