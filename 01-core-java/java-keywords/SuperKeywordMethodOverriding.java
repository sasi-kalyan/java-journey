
class First{
    public void method(){
        System.out.println("Parent Method");
    }
}

class Second extends First{
    @Override
    public void method(){
        System.out.println("Child Method");
    }

    public void getParentMethod(){
        super.method();
    }
}

public class SuperKeywordMethodOverriding {
    public static void main(String[] args) {
        Second obj = new Second();
        obj.method();
        obj.getParentMethod();
    }
}
