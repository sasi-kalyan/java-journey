import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    /*

          Set<E>  <<interface>>
          |
          | <- implements
          |
          HashSet<E> <<class>>

        - HashSet implements Set interface.
        - HashSet is backed up by the HashTable (usually HashMap<K, V>)
        - HashSet doesn't allow duplicates
        - HashSet doesn't maintain any order
        - HashSet allows null values, if we insert more than one null value it overrides
        - HashSet is not-synchronized, we can explicitly make it synchronized.

     */

    /*

        Internal Working of HashSet:
        - Lets take the example VIP Party:
        1. Each guest invited with unique id (no duplicates)
        2. We have 16 Rooms to allot each guest.
        3. Each guest has unique id (hashcode)
        4. We will decide room number based on the ID.

                          Number of element in HashSet
Load Factor Of HashSet =  ----------------------------
                              Size of the HashSet

     */
    public static void main(String[] args) {
        HashSet<String> partyGuest = new HashSet<>();

//        int guestId = "John".hashCode();
//        int roomNumber = guestId%16;
//
//        System.out.println("Guest Id: "+ guestId);
//        System.out.println("Room Number: "+ roomNumber);

        //add john
        partyGuest.add("John");
        System.out.println("after john: "+ partyGuest);

        //add alice
        partyGuest.add("Alice");
        System.out.println("after alice : "+ partyGuest);

        //duplicate john
        partyGuest.add("John");
        System.out.println("after duplicate john: "+ partyGuest);

        //contain method
        System.out.println(partyGuest.contains("John"));

        //isEmpty
        System.out.println("Is Empty: "+ partyGuest.isEmpty());

        //clear
        partyGuest.clear();
        System.out.println("Is Empty? "+ partyGuest.isEmpty());

        //this way we can make it synchronized.
        Set<Integer> syncSet = Collections.synchronizedSet(new HashSet<>());
    }
}
