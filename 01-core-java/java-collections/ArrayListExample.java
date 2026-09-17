import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //adding elements into the list
        list.add(10);
        list.add(30);
        list.add(50);
        list.add(60);
        list.add(90);

        //print list
        System.out.println("List: ");
        System.out.println(list);

        //change the element at some pos.
        list.set(2, 1000);

        //print list
        System.out.println("After changing 2 index: "+list);

        //remove element from the list
        list.remove(2);
        System.out.println("After removing 2 index: "+list);

        //Iterating the arraylist

        for(Integer i: list){
            System.out.print("["+i+"]"+" ");
        }

        System.out.println();

        //print size of teh arraylist
        System.out.println("size of the array list: "+list.size());

        //sort the arraylist
        Collections.sort(list);

        //print-list
        System.out.println("sorted list: "+list);

        //fetch some index
        System.out.println("Element at index 1: "+list.get(1));

        //find the index
        System.out.println("90 found in list? "+list.indexOf(90));

        //check the element avaibility
        System.out.println("check element availability? "+list.contains(90));
    }
}
