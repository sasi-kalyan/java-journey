package newproblems;

import com.sun.jdi.IntegerType;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberProblems {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(
                10, 25, 15, 30, 45, 20, 50, 60, 75, 90,
                10, 25, 30, 100, 120, 135, 150, 175, 200,
                5, 7, 9, 11, 13, 17, 19, 21, 23, 27, 29
        );

        //Find all even numbers.
        List<Integer> even = numbers.stream()
                .filter(n -> n%2==0)
                .collect(Collectors.toList());

        System.out.println("even numbers :" + even);

        //Find all odd numbers.
        List<Integer> odd = numbers.stream()
                .filter(n -> n%2!=0)
                .collect(Collectors.toList());
        System.out.println("odd numbers: "+ odd);

        //Count odd numbers
        Long countOdd = numbers.stream().count();
        System.out.println("odd numbers count: " + countOdd);

        //Count even numbers.
        Long countEven = numbers.stream().count();
        System.out.println("even number count : " + countEven);

        //Find sum of all numbers.
        int sumOfAll = numbers.stream().reduce(0, Integer::sum);
        int sumofAll = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum of all numbers: " + sumOfAll);

        //Find average of numbers.
        double avgOfNum = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
        System.out.println("average of numbers: " + avgOfNum);

        //Find maximum number.
        int max = numbers.stream().max(Integer::compare).get();
        System.out.println("maximum : "+ max);

        //Find minimum number
        int min = numbers.stream().min(Integer::compare).get();
        System.out.println("minimum : " + min);

        //Find second highest number.
        int secHighNum = numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("second hightest number: " + secHighNum);

        //Remove duplicate numbers
        List<Integer> removeDup = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("removed duplicates: " + removeDup);

        //Find the last element
        int findLst = numbers.stream().skip(numbers.size()-1).findFirst().get();
        System.out.println("find the last element: " + findLst);

        //Check if number exists.
        boolean isNumExists = numbers.stream().anyMatch(n -> n == 10);
        System.out.println("is 10 exists? "+ isNumExists);

        //Square every number.
        List<Integer> sqrNums = numbers.stream().map(n -> n*n).collect(Collectors.toList());
        System.out.println("squared numbers: " + sqrNums);

        //Find frequency of each number.

        Map<Integer, Long> freqNum = numbers.stream().collect(
                Collectors.groupingBy(
                        n->n,
                        Collectors.counting()
                )
        );

        System.out.println("frequency of each num: " + freqNum);

        //Find duplicate numbers.

        List<Integer> duplicates = numbers
                .stream().filter( n -> {
                        int idx = numbers.indexOf(n);
                        int lidx = numbers.lastIndexOf(n);
                        return (idx != lidx);
                    }
                ).collect(Collectors.toList());

        System.out.println("duplicate numberes: "+duplicates);

        //Find unique numbers.
        List<Integer> unique = numbers
                .stream().filter( n -> {
                            int idx = numbers.indexOf(n);
                            int lidx = numbers.lastIndexOf(n);
                            return (idx == lidx);
                        }
                ).collect(Collectors.toList());
        System.out.println("unique numberes: "+unique);

        Map<Boolean, List<Integer>>
                partitionEvenOdd = numbers.stream().collect(
                        Collectors.partitioningBy(
                                n->n%2==0
                        )
        );

        System.out.println(partitionEvenOdd);

        List<Integer> naturalNUms = Stream.iterate(0, n -> n + 1).limit(20).collect(Collectors.toList());
        System.out.println(naturalNUms);

    }
}
