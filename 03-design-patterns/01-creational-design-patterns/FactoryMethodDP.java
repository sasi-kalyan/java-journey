interface Factory{

    void save();
}

class TestA implements Factory{

    @Override
    public void save() {
        System.out.println("inside TestA");
    }
}

class TestB implements Factory{

    @Override
    public void save() {
        System.out.println("inside TestB");
    }
}

abstract class GenericTest{

    abstract Factory createTestObj();
}

class TestAImpl extends GenericTest{

    @Override
    Factory createTestObj() {
        return new TestA();
    }
}

class TestBImpl extends GenericTest{

    @Override
    Factory createTestObj() {
        return new TestB();
    }
}

public class FactoryMethodDP {

    /*
            Factory design pattern: creating the objects without exposing the actual creation logic.

            we shall define an interface to create the objects let the sublcasses decide to which class
            instantiation requires.
     */
    public static void main(String[] args) {

        GenericTest obj = new TestAImpl();
        Factory fobj = obj.createTestObj();
        fobj.save();
    }
}
