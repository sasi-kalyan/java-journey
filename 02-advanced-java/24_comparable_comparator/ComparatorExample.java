import java.util.*;

class User{
    private int id;
    String name;
    private int numReq;

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

public class ComparatorExample {
    public static void main(String[] args) {
        User u1 = new User(1, "Naruto", 300);
        User u2 = new User(2, "Gabimaru", 400);
        User u3 = new User(4, "Yagami Light", 310);

        List<User> list = new ArrayList<>(Arrays.asList(u1, u2, u3));
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        System.out.println("After sorted: "+ list);

    }
}
