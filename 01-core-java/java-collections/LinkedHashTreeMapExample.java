import java.util.*;

public class LinkedHashTreeMapExample {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Tesla");
        map.put(2, "Audi");
        map.put(3, "Skoda");

        System.out.println(map);

        Set entrySet = map.entrySet();
        System.out.println(entrySet);

        Set keys = map.keySet();
        System.out.println(keys);

        Collection c =  map.values();
        System.out.println(c);

        Iterator it = entrySet.iterator();

        while(it.hasNext()){
            Map.Entry ele = (Map.Entry)it.next();
            System.out.println(ele.getKey()+" "+ele.getValue());
        }

        //remove method

        map.remove(3);

        System.out.println(map);

        //replace method
        map.replace(2, "SpaceX");
        System.out.println(map);

    }

}
