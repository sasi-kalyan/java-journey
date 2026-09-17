
/*
    Strictfp: keyword that ensures that the floating point calucualtions should be
    consistent access all the platforms, but recent JVM doesn't need strictfp
    anymore all the JVM could able to perform the consistent floating point calculations.
 */
public strictfp class StrictFPClass {
    public void add(double a, double b){
        System.out.println("a+b: "+(a+b));
    }
    public static void main(String[] args){
        StrictFPClass strictFPClass = new StrictFPClass();
        strictFPClass.add(100.45d, 6789.452d);
    }
}
