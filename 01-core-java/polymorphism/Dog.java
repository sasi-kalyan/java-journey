public class Dog extends Animal{

    @Override
    public void sound() {
        System.out.println("Dog making sound...");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();

        Animal obj = new Dog();
        obj.sound();
    }
}
