import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteExample {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(100);
        list.add(500);

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


        //This iteration throws ConcurrentModificationException because ArrayList is not thread-safe
        // The mutating operations throws ConcurrentModificationException since the iterator is fail-fast iterator.
        System.out.println("iterating arraylist");
        for(Integer j : list){
            System.out.print(j+" ");
            list.add(500);
        }
    }
}
