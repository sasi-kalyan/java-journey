import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        //adding elements

        list.add(10);
        list.add(50);
        list.add(34);
        list.add(78);
        list.addFirst(100); //adding first
        list.addLast(900); //adding last

        //get elements
        System.out.println("element at first: "+list.getFirst());
        System.out.println("element at last: "+list.getLast());
        System.out.println("elelemt at pos: "+list.get(3));

        //remove the elements

        list.removeFirst();
        list.removeLast();

        System.out.println("After removing the elements: "+list);

        System.out.println("Index of 1 is: "+list.indexOf(1));
        System.out.println("last index of 34"+list.lastIndexOf(34));

        //other method include: removeFirstOccurrence, removeLastOccurrence, poll, pollFirst, pollLast, set, Collections.sort(list, Collections.reverseOrder()) etc...

    }
}
