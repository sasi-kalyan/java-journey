import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
    public static void main(String[] args) {

        CopyOnWriteArrayList<Integer> copy = new CopyOnWriteArrayList<>();
        copy.add(10);
        copy.add(30);
        copy.add(56);
        copy.add(67);
        copy.add(45);

        System.out.println("copyonwrite array-list elements");
        for(Integer i: copy){
            System.out.print(i+" ");
        }
    }
}
