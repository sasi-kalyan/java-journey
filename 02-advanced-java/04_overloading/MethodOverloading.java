
/*
        Method Overloading:
        It is the concept where we can define multiple methods with same name but those methods
        differ in
        1. sequence of parameters
        2. datatype of parameters
        3. number of parameters

 */

public class MethodOverloading {

    public void sum(int a, int b){
        System.out.println(a+b);
    }
    //change in datatypes
    public void sum(double a, double b){
        System.out.println(a+b);
    }

    public void sum(int a, double b){
        System.out.println(a+b);
    }
    //sequence of parameters different
    public void sum(double a, int b){
        System.out.println(a+b);
    }

    public void sum(float a, float b){
        System.out.println(a+b);
    }
    //number of parameters different
    public void sum(float a, float b, float c){
        System.out.println(a+b+c);
    }

    public static void main(String[] args) {
        MethodOverloading obj = new MethodOverloading();

        obj.sum(1, 2);
        obj.sum(1.02f, 1.54f);
        obj.sum(1.4f, 1.5f, 4.5f);
        obj.sum(3, 4.5d);
        obj.sum(4.5d, 6.7d);
    }
}
