import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(30);
        set.add(56);
        set.add(34);
        set.add(67);
        set.add(67);
        set.add(null);

        System.out.println(set);

        //remove elements from the set
        set.remove(67);

        //print set
        System.out.println(set);
    }
}
