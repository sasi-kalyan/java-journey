import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Top100Streams {
    public static void main(String[] args) {

        //1. Find the Sum of All Elements in a List
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum of elements: "+ sum);

        //2. Find the Product of All Elements in a List
        int product = numbers.stream().reduce((a,b) -> (a*b)).get();
        System.out.println("product of elements: "+ product);

        //3. Find the Average of All Elements in a List
        double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("average of elements: "+ avg);

        //4. Find the Maximum Element in a List
        int max = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("maximum element: "+ max);

        //5. Find the Minimum Element in a List
        int min = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("minimum element: "+ max);

        //6. Count the Number of Elements in a List
        long cnt = numbers.stream().count();

        //7. Check if a List Contains a Specific Element
        boolean match2 = numbers.stream().anyMatch(n -> (n==2));
        System.out.println("any match of 2: "+ match2);

        //8. Filter Out Even Numbers from a List
        List<Integer> evens = numbers.stream().filter(n -> n%2==0).collect(Collectors.toList());
        System.out.println("even list: "+ evens);

        //9. Filter Out Odd Numbers from a List
        List<Integer> odds = numbers.stream().filter(n -> n%2 != 0).collect(Collectors.toList());


        List<String> words = List.of("hello", "world");
        //10. Convert a List of Strings to Uppercase
        List<String> result = words.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println("after convertion to uppercase: "+ result);

        //11. Convert a List of Integers to Their Squares
        List<Integer> sqrs = numbers.stream().map(n -> n*n).collect(Collectors.toList());
        System.out.println("squares of numbers: "+ sqrs);

        //12. Find the First Element in a List
        Optional<Integer> firstEle = numbers.stream().findFirst();
        System.out.println("first element in the list: "+ firstEle.get());

        //13. Find the Last Element in a List
        int findLast = numbers.stream().reduce((a, b) -> b).orElse(0);
        System.out.println("last element in list: "+ findLast);

        //14. Check if All Elements in a List Satisfy a Condition
        boolean allMatch = numbers.stream().allMatch(n -> n%2==0);
        System.out.println("allMatch? "+ allMatch);

        //15. Check if Any Element in a List Satisfies a Condition
        boolean anyMatch = numbers.stream().anyMatch(n -> n%2==0);
        System.out.println("anyMatch? "+ anyMatch);

        //16. Remove Duplicate Elements from a List
        List<Integer> numList = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 6, 7, 0, 9, 3, 6));
        List<Integer> uniqueList = numList.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique elements list: "+ uniqueList);

        //17. Sort a List of Integers in Ascending Order
        List<Integer> sortedList = numList.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted list: "+ sortedList);

        //18. Sort a List of Integers in Descending Order
        List<Integer> revSort = numList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("reverse sorted list: "+ revSort);

        //19. Sort a List of Strings in Alphabetical Order
        List<String> strList = new ArrayList<>(Arrays.asList("Naruto", "Death Note", "One Piece", "Your Name", "Haikyuu"));

        List<String> strSort = strList.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted str list: "+ strSort);

        //20. Sort a List of Strings by Their Length
        List<String> strSortLen = strList.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        System.out.println("sorted str list by length: "+ strSortLen);

        //21. Find the Sum of Digits of a Number
        int number = 123456;
        int sumofNumbrs = String.valueOf(number).chars().map(Character::getNumericValue).sum();
        System.out.println("sum of numbers in number: "+ sumofNumbrs);

        //22. 23. Find the Second-Largest Element in a List
        List<Integer> numList2 = new ArrayList<>(Arrays.asList(1, 1, 3, 4, 6, 7, 0, 9, 3, 6));
        int secLargst = numList2.stream().sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();

        System.out.println("second largest element in list: "+ secLargst);

        //24. Find the Second-Smallest Element in a List
        int secSmall = numList2.stream().sorted().skip(1).findFirst().get();
        System.out.println("second smallest element in list: " + secSmall);

        //25. Find the Longest String in a List
        String longStr = strList.stream().sorted(Comparator.comparingInt(String::length))
                .sorted(Comparator.reverseOrder()).findFirst().get();
        List<String> stringList2 = strList.stream().sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        Collections.reverse(stringList2);
        System.out.println("longest string: "+ stringList2.get(0));
        System.out.println("str list: "+ stringList2);

        //26. Find the Shortest String in a List
        String shortest = strList.stream().min(Comparator.comparingInt(String::length)).get();
        System.out.println("shortest string: "+ shortest);

        //27. Group a List of Strings by Their Length
        Map<Integer, List<String>> grpbylen = strList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by Str Length: "+ grpbylen);

        //29. Partition a List of Integers into Even and Odd Numbers
        Map<Boolean, List<Integer>> partEvenOdd = numList.stream()
                .collect(Collectors.groupingBy(n -> n%2==0));
        System.out.println(partEvenOdd);

       //30. Merge Two Lists into a Single List
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1, 3, 5, 4));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 5, 6, 1));

        List<Integer> merge = Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList());
        System.out.println("Merge: "+ merge);

        //31. Find the Intersection of Two Lists
        List<Integer> intersection = l1.stream()
                .filter(l2::contains)
                .collect(Collectors.toList());

        System.out.println("Intersection: "+ intersection);

        //32. Find the Union of Two Lists
        List<Integer> union = Stream.concat(l1.stream(), l2.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Union: "+ union);

        //33. Find the Difference Between Two Lists
        List<Integer> diff = l1.stream()
                .filter(n -> !l2.contains(n))
                .collect(Collectors.toList());
        System.out.println("Difference : "+ diff);

        //34. Count the Occurrences of Each Element in a List
        Map<Integer, Long> numCount = numList2.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println("numbers count: "+ numCount);

    }
}
