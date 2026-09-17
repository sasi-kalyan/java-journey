
class Hello{
    static void message(){
        System.out.println("hello method()");
    }
}

class World extends Hello{
    static void message(){
        System.out.println("world method()");
    }
}

public class StaticBinding {
    public static void main(String[] args) {
        Hello obj = new Hello();
        World obj2 = new World();

        obj.message();
        obj2.message();
    }
}
