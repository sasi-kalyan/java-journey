
class Computer{

    void compute(){
        System.out.println("Computer is just a concept!");
    }
}

class Laptop extends Computer{
    @Override
    void compute(){
        System.out.println("Laptop is the implemebtation of the computer");
    }
}

public class DynamicBinding {
    public static void main(String[] args) {
        Computer obj = new Laptop();
        obj.compute();
    }
}
