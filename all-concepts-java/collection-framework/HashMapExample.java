import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {

        /*
            HashMap: is the key-value pair collection.

            HashMap is basically Array + LinkedList + Red Black Trees

            transient Node<K,V>[] table;

   class Node<K,V>{

    int hash;
    K key;
    V value;

    Node<K,V> next;
   }

         */
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "Naruto");
        map.put(4, "Death Note");
        map.put(6, "Slayer");
        map.put(6, "Hells Paradise");

        System.out.println("Map: "+ map);

        //remove key from the map
        map.remove(6);
        System.out.println("after 6 removal: "+ map);

        Set set = map.entrySet();
        System.out.println("entry set: "+ set);

        for(Map.Entry p : map.entrySet()){
            System.out.println("Key: "+ p.getKey()+" Value: "+ p.getValue());
        }

        //containsKey
        System.out.println("Map contains 4: ?"+ map.containsKey(1));

        //containsValue
        System.out.println("Map contains Naruto? "+ map.containsValue("Naruto"));

        //replace method in hashset
        map.replace(1, "Attack On Titan");

        System.out.println("after replace: "+ map);

        Set keys = map.keySet();
        System.out.println("all keys: "+ keys);

        Collection vals = map.values();
        System.out.println("all values: "+ vals);

    }
}
