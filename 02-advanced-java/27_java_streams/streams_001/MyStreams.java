package streams_001;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

record Employee(String name, String department, double salary, int age) {}

public class MyStreams {
    public static void main(String[] args) {

        // Object stream - BOTH versions available
        List<String> words = List.of("banana", "apple", "fig");
        List<String> naturalOrder = words.stream().sorted().toList();
        System.out.println("natural sorting order: " + naturalOrder);

        List<String> customOrder = words.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println("sorted based on length of string: " + customOrder);

        // Primitive stream - ONLY no-arg exists, no Comparator possible!
        int[] arr = IntStream.of(5, 2, 8, 1).sorted().toArray(); // [1, 2, 5, 8] - always ascending, no options

        List<Employee> employees = List.of(

                new Employee("John", "IT", 75000, 28),
                new Employee("Alice", "HR", 65000, 32),
                new Employee("Bob", "Finance", 85000, 40),
                new Employee("David", "IT", 92000, 35),
                new Employee("Emma", "Sales", 55000, 26),
                new Employee("Frank", "Marketing", 72000, 31),
                new Employee("Grace", "HR", 68000, 29),
                new Employee("Henry", "Finance", 81000, 45),
                new Employee("Isabella", "Sales", 60000, 27),
                new Employee("Jack", "IT", 98000, 38),

                new Employee("Kevin", "Marketing", 71000, 33),
                new Employee("Laura", "HR", 64000, 30),
                new Employee("Mike", "Finance", 88000, 41),
                new Employee("Nancy", "IT", 90000, 36),
                new Employee("Oliver", "Sales", 58000, 25),
                new Employee("Peter", "Marketing", 76000, 34),
                new Employee("Queen", "HR", 69000, 28),
                new Employee("Robert", "Finance", 83000, 42),
                new Employee("Sophia", "IT", 97000, 37),
                new Employee("Tom", "Sales", 61000, 29),

                new Employee("Uma", "Marketing", 73000, 32),
                new Employee("Victor", "Finance", 87000, 43),
                new Employee("William", "IT", 94000, 39),
                new Employee("Xavier", "Sales", 57000, 24),
                new Employee("Yash", "HR", 66000, 30),
                new Employee("Zara", "Finance", 89000, 41),

                // Duplicate Names
                new Employee("John", "Finance", 78000, 30),
                new Employee("Alice", "IT", 99000, 34),
                new Employee("Bob", "Sales", 62000, 27),

                // Same Salaries
                new Employee("Chris", "IT", 80000, 31),
                new Employee("Diana", "HR", 80000, 36),
                new Employee("Ethan", "Finance", 80000, 42),
                new Employee("Fiona", "Marketing", 80000, 30),

                // Same Ages
                new Employee("George", "IT", 95000, 35),
                new Employee("Helen", "Sales", 59000, 35),
                new Employee("Ian", "HR", 67000, 35),
                new Employee("Jenny", "Finance", 86000, 35),

                // Low Salaries
                new Employee("Kiran", "Support", 35000, 22),
                new Employee("Latha", "Support", 36000, 23),
                new Employee("Manoj", "Support", 37000, 24),

                // High Salaries
                new Employee("Nikhil", "Management", 150000, 45),
                new Employee("Pradeep", "Management", 170000, 48),
                new Employee("Ramesh", "Management", 190000, 50),

                // Young Employees
                new Employee("Sanjay", "Intern", 25000, 21),
                new Employee("Teja", "Intern", 26000, 20),
                new Employee("Uday", "Intern", 24000, 19),

                // Older Employees
                new Employee("Venkat", "Consulting", 120000, 58),
                new Employee("Arjun", "Consulting", 125000, 60),
                new Employee("Bhaskar", "Consulting", 118000, 57),

                // More duplicates for grouping
                new Employee("John", "IT", 75000, 28),
                new Employee("John", "IT", 75000, 28),

                // Same Department Heavy Data
                new Employee("Chaitanya", "IT", 93000, 33),
                new Employee("Deepak", "IT", 91000, 34),
                new Employee("Eshwar", "IT", 96000, 36),
                new Employee("Farhan", "IT", 97000, 37),
                new Employee("Gopal", "IT", 94000, 32),

                // Edge Cases
                new Employee("Hari", "Research", 0, 29),
                new Employee("Indra", "Research", -1000, 31)
        );


        //Comparator.comparing(keyExtractor) — sort by ONE field
        //.reversed() — flip the order
        List<Employee> sortedBySal = employees.stream().sorted(Comparator.comparing(Employee::salary).reversed()).toList();
        System.out.println("employees sorted by salary: " + sortedBySal);

        //.thenComparing usage.

        List<Employee> sortByDeptThenSal = employees.stream().sorted(Comparator.comparing(Employee::department)
                .thenComparing(Employee::salary, Comparator.reverseOrder())).toList();
        System.out.println(sortByDeptThenSal);

        List<Integer> list1 = Arrays.asList(1, null, 5, 6, 9);
        List<Integer> sortedList1 = list1.stream().sorted(Comparator.nullsFirst(Comparator.naturalOrder())).toList();
        System.out.println(list1);

        double salSum = employees.stream().mapToDouble(Employee::salary).sum();
        System.out.println("all salary employees sum : " + salSum);

        List<Double> allSalList = employees.stream().map(Employee::salary)
                .toList();
        System.out.println(allSalList);

        //boxed usage to conver the primitve streams to object streams we need .boxed to do that job, because .collect do not support collecting primitives

        List<Integer> convertedList = IntStream.of(1, 4, 5, 6, 7).boxed().toList();
        System.out.println(convertedList);

        IntSummaryStatistics intSummaryStatistics = IntStream.of(1, 4, 6, 8, 1, 3).summaryStatistics();
        System.out.println(intSummaryStatistics);

        DoubleSummaryStatistics onSalSummaryStats = employees.stream()
                .mapToDouble(Employee::salary).summaryStatistics();
        System.out.println(onSalSummaryStats);

        Map<String, List<String>> empByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(
                                Employee::name,
                                Collectors.toList()
                        )
                ));
        System.out.println(empByDept);

        System.out.println("==============================================================================================");

        //find highest salary employee in each department.


        //this gives highest salary employee by department (employee complete object)
        Map<String, Optional<Employee>>
                highSal = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::department,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Employee::salary)
                                )
                        )
                );

        //collectingAndThen -- gives you exact filed we want from the object , it act as finisher
        Map<String, String> highSalByDeptEmpname =
                employees.stream()
                                .collect(Collectors.groupingBy(
                                        Employee::department,
                                        Collectors.collectingAndThen(
                                                Collectors.maxBy(Comparator.comparingDouble(Employee::salary)),
                                                opt -> opt.get().name()
                                        )
                                ));

        System.out.println(highSalByDeptEmpname);


        Map<String, List<String>> allEmpNameInDept = employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(
                                Employee::name,
                                Collectors.toList()
                        )
                ));

        System.out.println(allEmpNameInDept);
    }
}
