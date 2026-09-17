
// Method overloading: based on difference in data type
class DataType{
    public int method(int a, int b){
        return a*b;
    }

    public int method(float a, float b){
        return (int)(a*b);
    }

    public int method(int a, float b){
        return (int)(a*b);
    }
}

public class MethodOverloadingDataType {
    public static void main(String[] args) {
        DataType obj = new DataType();
        System.out.println(obj.method(10, 20));
        System.out.println(obj.method(10, 45.6f));
        System.out.println(obj.method(45.6f, 89.7f));
    }
}
