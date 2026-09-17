package practice;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MasterWords {

    public static void main(String[] args) {

        List<String> words = List.of(
                "java",
                "spring",
                "java",
                "hibernate",
                "spring",
                "microservices",
                "docker",
                "java",
                "kafka",
                "redis",
                "docker",
                "moom",
                "pop",
                "MCACM"
        );


        //Convert all words to uppercase.
        List<String> uppcase = words.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Upper case words: " + uppcase);

        //Find duplicate words.
        List<String> dupWords = words.stream()
                .filter(s -> Collections.frequency(words, s) > 1).
                distinct().collect(Collectors.toList());
        System.out.println("duplicates lsit: " + dupWords);

        //Find the longest word
        Map<String, Integer> worLen = words.stream().
                        distinct().collect(
                                Collectors.toMap(
                                        n->n,
                                        String::length
                                )
                        );

        System.out.println(worLen.entrySet());
        String finalword = worLen.entrySet().stream().sorted(Comparator.comparingInt(e->e.getValue()))
                .map(e -> e.getKey()).findFirst().get();
        System.out.println("longest word: " + finalword);

        //Sort by length
        List<String> sortByLen = words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println("sorted using by length: " + sortByLen);

        //Find words containing er
        List<String> containsER = words.stream().
                filter(s -> s.contains("er"))
                .collect(Collectors.toList());
        System.out.println("containing er : " + containsER);

        Map<Integer, List<String>>
                groupByLen = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.toList()
                ));

        System.out.println("Group by length: " + groupByLen);

        //Find palindrome words.
       // words.addAll(List.of("mom", "kitik", "pop", "peep"));
        //System.out.println("updated word list:  " + words);

        List<String> palindromewords = words.stream()
                .filter(s -> s.equals(
                        new StringBuilder(s).reverse().toString()
                ))
                .collect(Collectors.toList());

        System.out.println("palindrome words " + palindromewords);
    }
}
