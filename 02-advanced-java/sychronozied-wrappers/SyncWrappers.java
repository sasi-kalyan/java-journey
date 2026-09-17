import java.util.*;

public class SyncWrappers {
    public static void main(String[] args) {

        //Since list is the non-synchronized we need to wrap it with synchronized
        /*
               Non-Synchronized collections
               - ArrayList
               - LinkedList
               - HashSet
               - HashMap

               Synchronized collections
               Legacy Collection
               - Vector - every method inside it, is synchronized
               - HashTable - every method inside it, is synchronized
         */
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(40);
        list.add(50);
        list.add(90);

        //Synchronized wrapper
        List<Integer> syncList = Collections.synchronizedList(list);
        Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
        Map<String, Integer> syncMap = Collections.synchronizedMap(new HashMap<>());

        //Iteration is not synchronized, we need to sync manually using the synchronized block.
        synchronized (syncList){
            for(Integer i: syncList){
                System.out.println(i);
            }
        }
    }
}
