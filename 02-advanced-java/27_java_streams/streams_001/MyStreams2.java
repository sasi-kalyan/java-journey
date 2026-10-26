package streams_001;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStreams2 {
    public static void main(String[] args) {

        Map<String, Integer> employeeSalary = Map.ofEntries(
                Map.entry("John", 75000),
                Map.entry("Alice", 82000),
                Map.entry("Bob", 65000),
                Map.entry("David", 95000),
                Map.entry("Emma", 58000),
                Map.entry("Frank", 72000),
                Map.entry("Grace", 68000),
                Map.entry("Henry", 91000),
                Map.entry("Isabella", 61000),
                Map.entry("Jack", 105000),
                Map.entry("Kevin", 73000),
                Map.entry("Laura", 64000),
                Map.entry("Mike", 87000),
                Map.entry("Nancy", 79000),
                Map.entry("Oliver", 56000)
        );


        employeeSalary.keySet().stream().forEach(System.out::println);
        employeeSalary.values().stream().forEach(System.out::println);

        Map<String, Integer> sortMapByValues =
                employeeSalary.entrySet().stream()
                        .sorted(Comparator.comparingInt(Map.Entry::getValue))
                        .collect(
                                Collectors.toMap(
                                        Map.Entry::getKey,
                                        Map.Entry::getValue,
                                        (e1, e2) -> e1,
                                        LinkedHashMap::new
                                )
                        );

        System.out.println(sortMapByValues);

        Map<String, Integer> map1 = Map.of("a", 1, "b", 2);
        Map<String, Integer> map2 = Map.of("b", 3, "c", 4);

        Map<String, Integer> mergedMap = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (k1, k2) -> k2
                        )
                );

        System.out.println(mergedMap);
    }
}
