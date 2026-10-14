import java.util.Arrays;
import java.util.List;

enum Status{
    IN_PROGRESS,
    OPEN,
    CLOSED
}

interface TestInterface{

    void print();
}

enum Role implements TestInterface{
    ADMIN,
    USER,
    ;


    @Override
    public void print() {
        System.out.println("this is test interface");
    }
}

enum SingletonClass{
    INSTANCE;
}

public class EnumExample {
    public static void main(String[] args) {

        Status p = Status.OPEN;

        if(p.equals(Status.OPEN)){
            System.out.println("OPEN STATUS");
        }

        List<Integer> nums = Arrays.asList(1, 4, 5, 6 ,7);

        int sum = nums.stream().reduce(0, (a,b) -> (a+b));
        System.out.println(sum);

        Role.ADMIN.print();

        SingletonClass singletonClass1 = SingletonClass.INSTANCE;
        SingletonClass singletonClass2 = SingletonClass.INSTANCE;
        System.out.println("is both objects equal? " + (singletonClass1 == singletonClass2));

    }
}
