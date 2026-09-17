
class Parent{
    int a = 10;
    String b = "Hello World";
}

class Child extends Parent{
    int a = 1000;
    String b = "SpringFramework";

    public void getValuesOfParent(){
        System.out.println("Values of parent class: "+super.a+" "+super.b);
    }
}

public class SuperKeywordDataMembers {
    public static void main(String[] args) {
        Child obj = new Child();
        System.out.println("Vlaues of Child Class: "+obj.a+" "+obj.b);
        obj.getValuesOfParent();
    }
}
