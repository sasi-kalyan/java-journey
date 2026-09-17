package problems;

import java.util.*;
import java.util.stream.Collectors;

public class IntermediateProblems {

    public static void main(String[] args) {

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        List<String> words = Arrays.asList("apple", "bananna", "cherry", "date", "elderberry"
        , "fig", "grape", "honeymoon", "iceberg", "jackfruit");

        List<Integer> sortDesc = nums.stream().sorted(
                Comparator.reverseOrder()
        ).collect(Collectors.toList());

        System.out.println(sortDesc);

        List<String> sortByLen = words.stream()
                .sorted(
                        Comparator.comparing(String::length)
                ).sorted().collect(Collectors.toList());

        System.out.println(sortByLen);

        int sumOfNums = nums.stream().mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum of nums: "+ sumOfNums);

        OptionalDouble avgNums = nums.stream()
                .mapToDouble(n->n).average();
        System.out.println("average of nums: "+ avgNums);

        int prodNums = nums.stream().
                reduce(1, (a, b) -> a * b).intValue();
        System.out.println("product of nums: "+ prodNums);

        List<String> charsW = words.stream().
                flatMap(w -> Arrays.stream(w.split("")))
                .collect(Collectors.toList());
        System.out.println("char array: "+ charsW);

        Map<String, List<Integer>> evenOdd = nums.stream()
                .collect(Collectors.groupingBy(
                        n -> (n %2==0 ? "Even" : "Odd")
                ));

        System.out.println(evenOdd);

        Map<Integer, List<String>> groupByLen =
                words.stream().collect(Collectors.groupingBy(
                        String::length
                ));

        System.out.println(groupByLen);

        Map<Boolean, List<Integer>>
                part5others = nums.stream()
                .collect(
                        Collectors.partitioningBy(
                                n -> n > 5
                        )
                );
        System.out.println(part5others);

        String joinStr = words.stream()
                .collect(Collectors.joining(","));
        System.out.println("joined string: "+ joinStr);
    }
}
