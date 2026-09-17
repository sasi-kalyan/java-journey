import javax.swing.*;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();

        vec.addElement(10);
        vec.addElement(30);
        vec.addElement(50);
        vec.addElement(90);
        vec.addElement(70);
        vec.addElement(56);

        //print list
        System.out.println(vec);

        //fetch the list elements
        for(int i=0;i<vec.size();i++){
            System.out.println(vec.elementAt(i));
        }

        Enumeration<Integer> e = vec.elements();

        Iterator<Integer> it = e.asIterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
