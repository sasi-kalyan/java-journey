import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsUtilExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Banana", "Apple", "Mango", "PineApple"));

        //sorting
        Collections.sort(list);
        System.out.println("after sort: "+ list);

        //reverse
        Collections.reverse(list);
        System.out.println("after reverse: "+ list);

        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 3, 4, 4, 5, 6, 8, 10));
        System.out.println("Frequency of 4 in List: "+Collections.frequency(nums, 4));
    }
}
