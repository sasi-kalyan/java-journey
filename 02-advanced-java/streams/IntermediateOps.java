import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IntermediateOps {
    /*
            Intermediate Operations:
            - filter: filters the collection
            - map: transforms the collection
            - peek: debug purpose
            - sorted: sorts the collection
            - distinct: removes duplicates
            - limit: limits the collection to specific number
            - skip: skips some elements
            - flatMap: flattens the nested structures

     */
    public static void main(String[] args) {

        //FILTER - filters the list of elements
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 1, 3, 5));

        //FILTER THE EVEN ELEMENTS
        List<Integer> evens = nums.stream().filter(n -> (n%2==0)).collect(Collectors.toList());
        System.out.println("EVEN LIST: "+ evens);

        //FILTER THE ELEMENTS HAVING 'A'
        List<String> names = new ArrayList<>(Arrays.asList("apple", "ball", "cat", "dog", "elephant"));
        List<String> filterNames = names.stream().filter(s -> (s.indexOf("a") != -1))
                .collect(Collectors.toList());
        System.out.println("FILTERED LIST: "+ filterNames);
        //FILTER THE ODD ELEMENTS
        List<Integer> odds = nums.stream().filter(n -> (n%2!=0)).collect(Collectors.toList());
        System.out.println("Even list: "+ odds);

        //MAP - transforms the elements in the collection
        List<Integer> mulby2 = nums.stream().map(n -> n*2).collect(Collectors.toList());
        System.out.println("after multiply by 2: "+ mulby2);
        List<String> anime = new ArrayList<>(Arrays.asList("naruto", "deathnote", "demonslayer", "yourname"));
        List<String> startsWithD = anime.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("after trasform to uppercase: "+ startsWithD);
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 6, 1, 3, 5));

        //FLATMAP -FLATTENS THE NESTED STRUCTURES
        List<List<Integer>> nested = Arrays.asList(
                Arrays.asList(10, 20, 40),
                Arrays.asList(56, 34, 45),
                Arrays.asList(90, 34, 56)
        );

        List<Integer> convertedList = nested.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("converted list: "+ convertedList);

        String[] chars = {"hello", "world", "programming"};

        List<String> stchars = Arrays.stream(chars).flatMap(
                w -> Arrays.stream(w.split(""))
        ).collect(Collectors.toList());

        System.out.println(stchars);

        //distinct -- gets distinct elements in the collection
        List<Integer> distinctNums = nums1.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct elements: "+ distinctNums);

        List<String> listStr = Arrays.asList("Tanjiro", "Yagami Light", "Hinata Shoyou", "Thoriffin", "Thors");

        List<String> pstr = listStr.stream().map(String::toLowerCase).distinct().collect(Collectors.toList());
        System.out.println("removed duplicates inside the list: "+ pstr);

        //sorted -- sorts the collection
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(5, 3, 2, 10, 12, 6, 1));
        List<Integer> sortedNums = nums2.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted list: "+ sortedNums);
        //sorted method -- that sorts in reverse order
        List<Integer> sortedNumsRev = nums2.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sorted list: "+ sortedNumsRev);

        System.out.println("nums2: "+ nums2);
        //peek -- debug/perform side effects
        List<Integer> peekEx = nums2.stream().peek(n -> System.out.println("peek element: "+ n))
                .filter(n -> (n%2==0))
                .peek(n-> System.out.println("peek element after filter: "+ n))
                .map(n -> n*2)
                .peek(n -> System.out.println("peek element after map: "+ n))
                .collect(Collectors.toList());

        //limit -- it limits the number of elements
        List<Integer> limitNums = nums2.stream().limit(3).collect(Collectors.toList());

        System.out.println("Limit nums: "+ limitNums);

        //skips -- skips elements
        List<Integer> skipNums = nums2.stream().skip(3).collect(Collectors.toList());
        System.out.println("skip nums: "+ skipNums);
    }
}
