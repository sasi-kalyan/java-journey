
//MethodOverlaoding : Number of Parameters
class NumberOfParameters{
    public int method(int a, int b){
        return (a+b);
    }

    public int method(int a, int b, int c){
        return (a+b+c);
    }

    public int method(int a, int b, int c, int d){
        return (a+b+c+d);
    }
}

public class MethodOverloadingNumberOfParameters {
    public static void main(String[] args) {
        NumberOfParameters obj = new NumberOfParameters();
        System.out.println("Two parameters sum: "+obj.method(10, 30));
        System.out.println("Three parameters sum: "+obj.method(10, 30, 60));
        System.out.println("Four parameters sum: "+obj.method(10, 30, 67, 90));

    }
}
