import javax.naming.Name;
import java.util.*;

/*
    Comparator is an interface wich allows the class to have multiple sort orderings rather a defult natural ordering
    it is the enchancement to solve the limitation of the comparable interface (natural ordering only).

    The main idea is, by using exteranl object called Comparator we need to compare two objects, and sort it accordingly.

    it belongs to package java.util.Comparator

 */

class User {
     int id;
    String name;
     int numReq;

    public User(int id, String name, int numReq) {
        this.id = id;
        this.name = name;
        this.numReq = numReq;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numReq=" + numReq +
                '}';
    }
}

class NameComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        return o1.name.compareTo(o2.name);
    }
}

class IdComparator implements Comparator<User> {


    @Override
    public int compare(User o1, User o2) {
        return o1.id - o2.id;
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        User u1 = new User(1, "Naruto", 300);
        User u2 = new User(2, "Gabimaru", 400);
        User u3 = new User(4, "Yagami Light", 310);

        List<User> list = new ArrayList<>(Arrays.asList(u1, u2, u3));
        /*Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });*/

        TreeSet<User> treeSet = new TreeSet<>(new NameComparator());

        treeSet.add(u1);
        treeSet.add(u2);
        treeSet.add(u3);

        System.out.println("tree set is: " + treeSet);

        Collections.sort(list, new NameComparator());

        System.out.println("After sorted using NameComparator: "+ list);

        Collections.sort(list, new IdComparator());

        System.out.println("After sorted IdComparator: "+ list);

    }
}
