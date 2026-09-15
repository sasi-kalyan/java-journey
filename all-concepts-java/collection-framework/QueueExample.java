import java.util.*;

public class QueueExample {

    /*
           Queue: Elements are added to the queue on the ending side of the queue,
           and we remove the elements from front of the queue, it is the FIFO - first in
           first out data structure.

                                         Queue<E>  <<interface>>
                                         /       \
                   <<interface>    Deque<E>       PriorityQueue<E>  <<interface>>
                                     /
                     <<class>> LinkedList
     */
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<String> pqueue = new PriorityQueue<>();
        Deque<Integer> deque = new ArrayDeque<>();

        //adding the elements
        queue.add(10);
        queue.add(30);
        queue.add(60);

        //offer method
        queue.offer(90);

        System.out.println("elements in the queue are: " + queue);

        //remove the elements
        int a = queue.remove();
        System.out.println("removed element is (removed): " + a);

        //poll metthod
        int b = queue.poll();
        System.out.println("removed element is (poll) : " + b);
    }
}
