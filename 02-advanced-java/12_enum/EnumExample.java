import java.util.Arrays;
import java.util.List;

enum Status{
    IN_PROGRESS,
    OPEN,
    CLOSED
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

    }
}
