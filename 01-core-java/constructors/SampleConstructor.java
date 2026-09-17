
public class SampleConstructor{

    private int age;
    private String name;

    SampleConstructor(){
        //default constructor
    }
    public static void main(String[] args){
        SampleConstructor obj = new SampleConstructor();  //calling constructor
        System.out.println(obj.age);  //0
        System.out.println(obj.name); //null
    }
}