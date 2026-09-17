package practice;

import java.util.*;
import java.util.stream.Collectors;

public class MasterNumber {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(
                5,9,2,8,7,9,4,2,11,15,
                18,25,30,11,7,6,20,1,99,100
        );

        //1. Find all even numbers.

        List<Integer> evenList = numbers.stream().filter(n -> n%2 == 0).collect(
                Collectors.toList()
        );

        System.out.println("Even numbers list: " + evenList);

        //2. Find numbers greater than 50.
        List<Integer> gt50 = numbers.stream().filter(
                n -> n > 50
        ).collect(
                Collectors.toList()
        );

        System.out.println("Greater than 50 numbers list: " + gt50);

        //3. Find numbers less than 10.
        List<Integer> lt10 = numbers.stream().filter(
                n -> n < 10
        ).collect(Collectors.toList());

        System.out.println("Number list less than 10: " + lt10);

        //4. Find count of elements.
        long countOfElements = numbers.stream().count();
        System.out.println("Count of elements in stream: " + countOfElements);

        //5. Find minimum number.
        int minNum = numbers.stream().min(Integer::compare).get();

        //6. Find maximum number
        int maxNum = numbers.stream().max(Integer::compare).get();

        //7. Find average.
        OptionalDouble avg = numbers.stream().mapToDouble(Integer::doubleValue)
                .average();
        System.out.println("Average of the elements: " + avg);

        //8. Find sum
        long sumOfEle = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of the elements: " + sumOfEle);

        //9. Remove duplicate elements
        List<Integer> removeDupEle = numbers.stream().distinct().collect(Collectors.toList());

        //10. Sort ascending.
        List<Integer> sortAsc = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted list: " + sortAsc);

        //11/ Sort descending
        List<Integer> sortDesc = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("sorted list (desc) : " + sortDesc);

        //12. Skip first 5 numbers.
        List<Integer> skip5 = numbers.stream().skip(5).collect(Collectors.toList());
        System.out.println("Skipped 5 elements: " + skip5);

        //13. Get first 7 elements
        List<Integer> limit7 = numbers.stream().limit(7).collect(Collectors.toList());
        System.out.println("Limit 7 elements: " + limit7);

        //14. Get first element
        Optional<Integer> firstEle = numbers.stream().findFirst();
        System.out.println("first element: " + firstEle.orElse(-1));

        //15. Convert Integer List to String List.
        List<String> strList = numbers.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());
        System.out.println("string list: " + strList);

        /*
                INTERMEDIATE PROBLEM SET
         */

        //1. Find second highest number.
        int secHigh = numbers.stream().sorted(Comparator.reverseOrder())
                .skip(1).limit(1).findFirst().get();

        System.out.println("second highest number: " + secHigh);

        //2. Find duplicate numbers.
        List<Integer> dupnum = numbers.stream().
        filter(n -> {
            int fInd = numbers.indexOf(n);
            int lInd = numbers.lastIndexOf(n);
            return fInd != lInd;
        }).distinct().collect(Collectors.toList());

        System.out.println("duplicate numbers: " + dupnum);

        //3. Count frequency of each number.
        Map<Integer, Long> freq =
                numbers.stream().collect(
                        Collectors.groupingBy(
                                n->n,
                                Collectors.counting()
                        )
                );

        System.out.println("Frequency of Each number: " + freq);

        Map<Boolean, List<Integer>>
                partitionEvenOdd = numbers.stream().collect(Collectors.
                partitioningBy(
                        n -> n%2==0
                ));

        System.out.println("partition by even and odd : " + partitionEvenOdd);

        //Find product of all numbers.
        long prodOfAll = numbers.stream().
                mapToInt(Integer::intValue).reduce(1, (a,b)->a*b);
        System.out.println("product of all numbers: " + prodOfAll);

        //Find sum of squares.
        long sumofsqr = numbers.stream().map(n->n*n)
                .reduce(0, (a, b) -> a+b);
        System.out.println("sum of squares of the numbers: " + sumofsqr);

        //Find hightest even number
        long highEven  =numbers.stream().filter(n->n%2==0)
                .sorted(Comparator.reverseOrder())
                .findFirst().get();
        System.out.println("hightest even number : " + highEven);

    }
}
