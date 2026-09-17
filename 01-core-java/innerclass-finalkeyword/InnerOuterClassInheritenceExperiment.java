
class OuterClassExp{
    public void method(){
        System.out.println("Outer-parent class");
    }

    class InnerClassExp extends OuterClassExp{
        @Override
        public void method() {
            System.out.println("Inner-child class");
        }
    }
}

public class InnerOuterClassInheritenceExperiment {
    public static void main(String[] args) {
        OuterClassExp.InnerClassExp obj = new OuterClassExp().new InnerClassExp();
        obj.method();
    }
}
