

abstract class Mobile{
    abstract void ram();
    abstract void camera();

    void display(){
        System.out.println("Mobile provides apps and computations");
    }
}

class Nothing extends Mobile{
    public void ram(){
        System.out.println("256GB");
    }
    public void camera(){
        System.out.println("50px");
    }
}

public class AbstractClassExample {
    public static void main(String[] args) {
        Mobile obj = new Nothing();
        obj.camera();
        obj.ram();
    }
}
