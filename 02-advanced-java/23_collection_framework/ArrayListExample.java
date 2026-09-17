import java.util.*;

/*
        ArrayList: is the class that implements the List<T> interface, which stores the ordered collection of elements
        allows null elements as well.

            List<T>  <<inteface>>
            |
            |  <- implements
            |
            ArrayList<T> <<class>>

        - ArrayList can grow and shrink dynamically.
        - It maintains the insertion order
        - Fast random access, slow in insertions in the middle
        - ArrayList is non-synchronized

        => extends AbstractList, implements List, RandomAccess, Clonable, Serializable.
 */

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> anime = new ArrayList<>();

        //Adding Elements
        anime.add("Hell's Paradise");
        anime.add("Naruto Shippuden");
        anime.add("Demon Slayer");
        anime.add("Death Note");

        //Print arraylist
        System.out.println("Anime List: "+ anime);

        //Adding element as specific pos
        anime.add(3, "Chainsaw Man");

        System.out.println("After adding at pos : 3: "+ anime);

        //Change the element in arraylist
        anime.set(2, "Naruto Classic");
        System.out.println("After chainging at pos 2: "+ anime);

        //remove the elements from arryalist
        anime.remove("Naruto Classic");

        //remove elements at specific pos
        anime.remove(0);

        System.out.println("after removal: "+ anime);

        //iterating the arraylist
        for(String i: anime){
            System.out.print(i+" ");
        }
        System.out.println();

        //Using iterator we can loop the elements inside list
        Iterator<String> itstr = anime.iterator();

        while(itstr.hasNext()){
            System.out.print(itstr.next() + " ");
        }
        System.out.println();

        //size of the arraylist
        System.out.println("Size of arraylist: "+ anime.size());

        //sort the arraylist
        Collections.sort(anime);
        System.out.println("after sort:  "+ anime);

        //search the arraylist
        int index = Collections.binarySearch(anime, "Death Note");
        System.out.println("Found at index: "+ index);

        System.out.println("Using iterator to iterate the list");
        Iterator<String> it = anime.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();

        System.out.println("Using list iterator to iterate the list in bidirectinal way");
        ListIterator<String> lit = anime.listIterator();

        while(lit.hasNext()){
            System.out.print(lit.next()+"->");
        }

        System.out.println();
        //backward tracking
        while(lit.hasPrevious()){
            System.out.print(lit.previous()+"->");
        }
    }
}
