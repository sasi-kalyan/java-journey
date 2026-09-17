import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample2 {
    public static void main(String[] args) {

        //from collection
        List<String> strList = Arrays.asList("A", "B", "C");
        Stream<String> st1 = strList.stream();
        Stream<String> pst1 = strList.parallelStream();

        //from values
        Stream<String> st2 = Stream.of("hello", "to", "streams", "api", "concept");
        Stream<Integer> ist1 = Stream.of(1, 3, 5, 6, 7);

        //range streams
        IntStream its1 = IntStream.range(1, 3);
        IntStream its2 = IntStream.rangeClosed(1, 5);

        //intermediate operations

        //filter method - Filters the elements based on condition

        List<Integer> nums = Arrays.asList(1, 3, 5, 6, 8, 2, 0, 4, 19, 23, 45, 67, 21);

        //get even numbers
        List<Integer> even = nums.stream().filter(n -> n%2 == 0).collect(Collectors.toList());
        System.out.println("even numbers: "+ even);

        //map - Transforms the elements

        //multiply the odd digits with 3 by filtering the collection
        List<Integer> mulodd3 = nums.stream().filter(n->n%2!=0).map(n -> n*3).collect(Collectors.toList());
        System.out.println(mulodd3);

        //distinct - That gives the distinct list of nums

        List<Integer> dist = nums.stream().distinct().skip(3)
                .limit(3).collect(Collectors.toList());
        System.out.println(dist);

    }
}
