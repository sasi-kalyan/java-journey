import java.util.*;

class Employee {
    String name;
    int id;
    Employee(String name, int id) { this.name = name; this.id = id; }
    // NO equals() or hashCode() override!
}

public class HashMapExample {
    public static void main(String[] args) {

        /*
            HashMap: is the datastructure that stores the key-value pairs using hashing.

            Internally, hashmap can be described as array of bucket / bucket array

            // Simplified from actual JDK source
            transient Node<K,V>[] table;      // the bucket array
            transient int size;                // number of key-value mappings
            int threshold;                     // resize trigger point = capacity * loadFactor
            final float loadFactor;             // default 0.75

            static class Node<K,V> {
                final int hash;
                final K key;
                V value;
                Node<K,V> next; // forms a linked list for collisions in the same bucket
            }

            HashMap is basically Array + LinkedList + Red Black Trees

            By default the initial capacity = 16, loadFactor = 0.75, threshold = 12 (once we add 13th element the whole
            hashmap resized and rehashes the keys in the hashmap).

            ------------------------   ---------------------------
            |                      |   |                         |
            |  [hash, k,v, nxt] => |   | [hash, k,v, nxt] => ... | ....so on (initially 16)
            |                      |   |                         |
            ------------------------   ---------------------------

            STEP-1: why Java doesn't just use key.hashCode() directly

            // Actual JDK source (HashMap.hash method)
            static final int hash(Object key) {
                int h;
                return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            }

            here the hashmap uses the hashspreading algorithm where it can distribite the nodes to
            the bucker evenly preventing all the nodes goes to same bucket (it may increase the overhead and time complexity =)

            Step 2: Bucket index via bitwise AND, not modulo
            int index = (table.length - 1) & hash;

            Step 3: Collision handlding.
            TREEIFY_THRESHOLD = 8 — once a single bucket's chain reaches 8 nodes, it's converted to a red-black tree (O(log n) lookup instead of O(n)).
            MIN_TREEIFY_CAPACITY = 64 — if the table itself is still small, it resizes the whole table FIRST instead of treeifying (since growing the table often resolves the collision problem more cheaply than maintaining a tree).
            UNTREEIFY_THRESHOLD = 6 — shrinks back to a linked list if removals bring the count back down.


            Step 4: Resizing (rehashing)
            When size > threshold (i.e., capacity * 0.75), the HashMap doubles its capacity and rehashes every existing entry into the new, larger table.


            Important facts:
            hashmap allows one null key and multiple null values.
            if the two objects are equal according to the equals() both should have same hashcode.
            if the two objects have same hashcode need not to be same < this is called hash collision>
            hashCode() must be consistent — calling it multiple times on the same (unmodified) object must always return the same value.


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


        String str = "DataType";
        HashMap<String, Integer> tmpMap = new HashMap<>();

        tmpMap.put(str, 1);
        tmpMap.put(str.toUpperCase(), 1);
        tmpMap.put(str.toLowerCase(), 1);

        System.out.println(tmpMap.getOrDefault("Datatype", -1));

        System.out.println(tmpMap);


        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("John", 101));
        employees.add(new Employee("John", 101)); // "logically" the same employee
        System.out.println(employees.size());

    }
}
