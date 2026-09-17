
interface Phone{

    String manfacturer = "Apple,Inc";
    void ram();
    void camera();

}

class iPhone14 implements Phone{
    @Override
    public void ram() {
        System.out.println("256GB");
    }

    @Override
    public void camera() {
        System.out.println("50px");
    }
}



public class InterfaceExample {
    public static void main(String[] args) {
        Phone obj = new iPhone14();
        obj.camera();
        obj.ram();
        System.out.println(Phone.manfacturer);
    }
}
