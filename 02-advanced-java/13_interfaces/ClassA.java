public class ClassA implements InterfaceExample{

    public void method2() {
        System.out.println("implemented method");
    }

    public static void main(String[] args) {
        InterfaceExample obj = new ClassA();
        obj.method2();
    }
}
