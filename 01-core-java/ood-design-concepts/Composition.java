
class Heart{
    void pumpBlood(){
        System.out.println("Heart is pumping blood...");
    }
}

class Human{
    private Heart heart;

    public Human() {
        this.heart = new Heart();
    }

    public void live(){
        System.out.println("Human lives...");
        heart.pumpBlood();
    }
}


public class Composition {
    public static void main(String[] args) {
        Human obj = new Human();
        obj.live();
    }
}
