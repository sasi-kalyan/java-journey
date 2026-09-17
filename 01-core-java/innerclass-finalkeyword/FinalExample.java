
//final class Final{
//    void method(){
//        System.out.println("Parent Class (with final feature)");
//    }
//}

class ChildClass{
//    @Override
//    public void method(){
//        System.out.println("Child implemeting final class");   //Cannot inherit from final 'Final'
//    }

    final int a;
    ChildClass(int value){   // with constructor we can initialize the final variable
        a = value;
    }

    final void printMethod(){  // final methods cannot be overridden
        System.out.println("a value is: "+a);
    }

    void newMethod(){
        System.out.println("Childclass method, final objects cannot be initalized from one to another");
    }

//    void updateAvalue(){
//        a = 40; // error : Cannot assign a value to final variable 'a'
//    }
}

public class FinalExample {

    public static void main(String[] args) {
        final ChildClass obj = new ChildClass(100);
        ChildClass obj2 = new ChildClass(1000);
        //obj = obj2;  //final objects cannot be changed with another object
    }

}
