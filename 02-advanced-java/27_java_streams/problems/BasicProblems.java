package problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BasicProblems {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14);
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        List<String> words = Arrays.asList("apple", "bananna", "cherry", "date", "elderberry");

        //1. write a stream to filter all the even nums
        List<Integer> even = nums.stream()
                .filter(n -> n%2==0)
                .collect(Collectors.toList());
        System.out.println("even nums list: "+ even);

        //2. write stream to convert all str to uppercase
        List<String> upnames = names.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("uppercase names: "+ upnames);

        //3. write a stream to filter > 5 and multiply with 2
        List<Integer> g5M2 = nums.stream().filter(n -> n > 5).map(n -> n * 2)
                .collect(Collectors.toList());
        System.out.println("Greater 5 Multiply 2: "+ g5M2);

        //4. write a stream to transform each str with prefix as hello
        names.stream()
                .map(s -> "hello "+ s)
                .forEach(System.out::println);

        //5. write a stream to count numbers greater than 5
        long c = nums.stream().filter(n->n>5).count();
        System.out.println("count numbers > 5: "+ c);

        //6. write a stream find any divisible by 7
        Optional<Integer> findDivBy7 = nums.stream()
                .filter(n->n%7==0)
                .findAny();

        System.out.println("divisible by 7: "+ findDivBy7);

        //7. write a stream check all nums +ve
        boolean checkpostve = nums.stream()
                .anyMatch(n->n>0);
    }
}
