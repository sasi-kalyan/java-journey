
class OutClass{
    public int ser = 100;
    public String packets = "10001010";

    class Inner{
        public int innerSer = 200;
        public String innerPackets = "000000011";

        public void innerMethod(){
            System.out.println("Inner Class Method");
        }
    }

    public void outerMethod(){
        System.out.println("Outer Class Method");
    }
}

public class JavaInnerClassExample {
    public static void main(String[] args) {
        OutClass.Inner obj = new OutClass().new Inner();

        System.out.println("Inner Class Variables");
        System.out.println(obj.innerSer+" "+obj.innerPackets);
        obj.innerMethod();

        OutClass obj2 = new OutClass();
        System.out.println("Outer class Variables");
        System.out.println(obj2.ser+" "+obj2.packets);
        obj2.outerMethod();
    }
}
