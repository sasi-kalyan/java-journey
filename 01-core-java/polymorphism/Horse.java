public class Horse extends Animal{
    @Override
    public void sound() {
        System.out.println("Horse making sound...");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();

        Animal obj = new Horse();
        obj.sound();
    }
}
