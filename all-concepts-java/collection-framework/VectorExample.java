import java.util.Vector;

public class VectorExample {
    /*
            Vector: Implements the List, Like ArrayList it also maintains the insertions order
            - It is thread-safe arraylist
            - since every method inside the vector is synchronized
            in nature, in multithreaded environment it gives poor performance.



            => extends AbstractList<E>
                implements List<E>, RandomAccess, Cloneable, java.io.Serializable
     */

    public static void main(String[] args) {


        Vector<String> vector = new Vector<>();  //it creates vector with default cap of 10

        Vector<Integer> invec = new Vector<>(10, 5); //inital capacity: 10, increments by 5

        //adding the elements
        vector.add("naruto");
        vector.addElement("demon slayer");

        System.out.println("vector: "+ vector);

        //accessing the elemets
        System.out.println(vector.get(0));
        System.out.println("first element: "+ vector.firstElement());
        System.out.println("last element: "+ vector.lastElement());

        //removing the elements
        vector.remove("demon slayer");

        System.out.println("after removal: "+ vector);


        //capacity of the vector
        System.out.println("capactiy of the vector: "+ vector.capacity());

        //size of the vector
        System.out.println("vector size: " + vector.size());

        //isempty method
        System.out.println("is vector empty ? " + vector.isEmpty());


    }
}
