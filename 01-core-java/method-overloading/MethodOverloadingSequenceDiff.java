
//Method Overloading: Difference in Sequence
class SequenceDiff{
    public float method(int a, int b, float c){
        return (a*b*c);
    }

    public float method(float a, int b, int c){
        return (a*b*c);
    }
}

public class MethodOverloadingSequenceDiff {
    public static void main(String[] args) {
        SequenceDiff obj = new SequenceDiff();
        System.out.println(obj.method(10.4f, 5, 56));
        System.out.println(obj.method(10, 45, 67.4f));
    }
}
