
class Calculator{
    public int add(int a, int b){
        return a+b;
    }

    public float add(float a, float b){
        return a+b;
    }

    public float add(int a, float b){
        return a+b;
    }
}

public class MethodOverloading1 {
    public static void main(String[] args) {
        Calculator obj = new Calculator();
        System.out.println(obj.add(10, 20));
        System.out.println(obj.add(10.45f, 11.23f));
        System.out.println(obj.add(10, 45.6f));
    }
}
