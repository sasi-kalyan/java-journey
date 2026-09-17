
class P{
    int p = 10;
    public void methodP(){
        System.out.println("P method");
    }
}

class Q extends P{
    int q = 20;
    public void methodQ(){
        System.out.println("Q method");
    }
}

class R extends Q{
    int r = 30;
    public void methodR(){
        System.out.println("R method");
    }
}

public class MultiLevelInheritence {
    public static void main(String[] args) {
        R obj = new R();
        System.out.println("P value : "+obj.p);
        System.out.println("Q value : "+obj.q);
        System.out.println("R value : "+obj.r);

        obj.methodP();
        obj.methodQ();
        obj.methodR();
    }
}
