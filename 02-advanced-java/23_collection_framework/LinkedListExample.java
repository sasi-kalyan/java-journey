import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {

    /*
            LinkedList:
            - LinkedList is the linear data structure just like arrays, but elements would not store in contiguous
              memory locations like arrays, random memory locations allocates for each node, ecah node have the address
              to its neighbouring node.

              List<T>  <<inteface>>
              |
              LinkedList<T>  <<class>>

            - It also dynamically grow and shrink
            - Fast insertions/ deletions from both ends but slow in random access

            => AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable
     */
    public static void main(String[] args) {
        LinkedList<String> anime = new LinkedList<>();

        //adding elements
        anime.add("Death Note");
        anime.add("Frieren: Beyond Journey's End");
        anime.add("Attack On Titan");

        //print elements in linkedlist
        System.out.println("anime list: "+ anime);

        //adding element at specific pos
        anime.add(2, "Demon Slayer");

        //add first and add last
        anime.addFirst("Hell's Paradise");
        anime.addLast("Fullmetal Alchemist");

        //change element
        anime.set(0, "One Piece");

        System.out.println("after adding and changing: "+ anime);

        //remove at specific pos
        anime.remove(1);

        //remove certain obj
        anime.remove("One Piece");

        System.out.println("after removal: "+ anime);

        //remove first, removeLast
        anime.removeFirst();
        anime.removeLast();
        System.out.println("after removal of first and last: "+ anime);

        //Iterator in LinkedlIst
        Iterator<String> itstr = anime.iterator();

        //LinkedList collection works on fail-fast iterator.
        while (itstr.hasNext()){
            //anime.remove("Attack On Titan");   //java.util.ConcurrentModificationException
            System.out.print(itstr.next() + " ");
        }

        System.out.println();
    }
}
