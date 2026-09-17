
class SuperClass{

    SuperClass(){
        System.out.println("Super-Class Type");
    }

    public SuperClass method(){
        return new SuperClass();
    }
}

class SubClass extends SuperClass{
    SubClass(){
        System.out.println("Sub-Class Type");
    }

    @Override
    public SubClass method() {
        return new SubClass();
    }
}


public class CovariantReturnTypes {
    public static void main(String[] args) {
        SuperClass obj = new SubClass();
        SuperClass getObj = obj.method();
        System.out.println(getObj.getClass());
    }
}
