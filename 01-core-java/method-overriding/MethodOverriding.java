
class MethodOverridingExample{
    public void method(){
        System.out.println("Overridden method");
        System.out.println("Parent class - method");
    }
}

class SubClassMethodOverridingExample extends MethodOverridingExample{

    @Override
    public void method(){
        System.out.println("Overriding method");
        System.out.println("Child class - method");
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        MethodOverridingExample pobj = new MethodOverridingExample();
        pobj.method();

        SubClassMethodOverridingExample obj = new SubClassMethodOverridingExample();
        obj.method();
    }
}
