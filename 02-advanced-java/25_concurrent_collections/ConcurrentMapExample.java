import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {
    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> cmap = new ConcurrentHashMap<>();

        cmap.put("Naruto", 1);  //locks the bucket where the key goes, and remaining buckets will be free for concurrent operations.
        cmap.get(1);   //read is the non-locking operation

        cmap.putIfAbsent("DemonSlayer", 3); //puts the data in the hashmap whent the data not present

        cmap.compute("DemonSlayer", (k,v) -> v+1);

        System.out.println(cmap);
    }
}
