import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOps {

    /*
            Terminal Operations:
            - forEach
            - wqe(Collector)
            - reduce: reduces collection to single value
            - min: finds minimum
            - max: finds maximum
            - anyMatch: returns true if any match found
            - allMatch: return true all matches
            - noneMatch: returns true no matches
            - findFirst: gets the first
            - findAny: gets any if eligible
            - toArray: converts to array
     */
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 1, 3, 5));

        //forEach
        nums.forEach(System.out::println);

        //collect - collects to collection
        List<Integer> evens = nums.stream()
                        .filter(n -> n%2==0)
                        .collect(Collectors.toList());

        //to specific collection
        ArrayList<Integer> list = nums.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println("ArrayList Collection: "+ list);


        //reduce -- reduces to single value
        int val = nums.stream().reduce((a,b) -> a+b).get();
        System.out.println("sum of elements: "+ val);

        int val2 = nums.stream().reduce(0, (a,b)->a+b).intValue();
        System.out.println("sum of elements: "+ val2);

        //count -- counts the elements in collection
        long cnt = nums.stream().count();
        System.out.println("count of elements: "+ cnt);

        //min/max
        int min = nums.stream().min(Integer::compare).get();
        int max = nums.stream().max(Integer::compare).get();
        System.out.println("min: "+ min+" max: "+max);

        //anyMath/ allMatch/ noneMatch

        boolean res1 = nums.stream().anyMatch(n -> n%2==0);
        boolean res2 = nums.stream().allMatch(n -> n%2==0);
        boolean res3 = nums.stream().noneMatch(n -> n%2!=0);

        System.out.println(res1+" "+ res2+" "+ res3);
    }
}
