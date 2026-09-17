package streamtricks;

import java.util.*;
import java.util.stream.Collectors;

class Employee{
    private Long id;
    private String name;
    private String department;
    private int salary;
    private int age;
    private String gender;

    public Employee(Long id, String name, String department, int salary, int age, String gender) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public  int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

public class Code1 {

    public static void main(String[] args) {
        List<Employee> employees = List.of(

                new Employee(1L, "John", "IT", 75000, 28, "Male"),
                new Employee(1L, "Sarah", "HR", 65000, 32, "Female"),
                new Employee(3L, "David", "Finance", 85000, 40, "Male"),
                new Employee(4L, "Emma", "IT", 95000, 30, "Female"),
                new Employee(5L, "Michael", "Admin", 50000, 45, "Male"),
                new Employee(6L, "Sophia", "IT", 72000, 25, "Female"),
                new Employee(7L, "James", "HR", 55000, 29, "Male"),
                new Employee(8L, "Olivia", "Finance", 90000, 35, "Female"),
                new Employee(9L, "William", "IT", 110000, 38, "Male"),
                new Employee(10L, "Mia", "Finance", 78000, 27, "Female"),
                new Employee(11L, "Daniel", "HR", 62000, 34, "Male"),
                new Employee(12L, "Charlotte", "Admin", 58000, 31, "Female"),
                new Employee(13L, "Lucas", "IT", 72000, 23, "Male"),
                new Employee(14L, "Amelia", "Finance", 120000, 42, "Female"),
                new Employee(15L, "Henry", "HR", 68000, 37, "Male")
        );


        //This will collect into list
        List<String> emps = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("List of employees: " + emps);

        //This will collect into set to removes duplicates
        Set<String> emps2 = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println("Set of employees: " + emps2);

        //Convert the list to map.
        Map<Long, String> emps3 = employees.stream()
                .collect(
                        Collectors.toMap(
                                Employee::getId,
                                Employee::getName,
                                (oldName, newName) -> newName
                        )
                );
        System.out.println("Map of employees: " + emps3);

        //join the strings with something
        String result1 = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        System.out.println("All names joined: " + result1);

        //Count all employees in the list
        long total = employees.stream().collect(Collectors.counting());
        System.out.println("Total employees: " + total);

        //Count total salary of the employees
        long total_sal = employees.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("Total salaries of the employees: " + total_sal);

        //Count avg salary of each employee
        Double avg_sal = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("Average salary of employee: " + avg_sal);

        //Get maximum salaried employee
        Optional<Employee> opt_emp = employees.stream()
                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));

        System.out.println("Maximum salary employee : " + opt_emp.get().getName());

        //Get maximum salary in each department
        Map<String, Integer> max_sal_dept_wise = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(
                                                Employee::getSalary
                                        ))
                                        ,
                                        opt->opt.get().getSalary()
                                )
                        )
                );

        System.out.println(max_sal_dept_wise);

        /*
                Keys - department
                Values - Object x -> only salary
         */

        //Summarizing int

        IntSummaryStatistics statistics = employees.stream().collect(
                Collectors.summarizingInt(Employee::getSalary)
        );

        System.out.println("Statistics: " + statistics);

        //Group emps by department
        Map<String, List<String>> group_by_dept =
                employees.stream().collect(
                        Collectors.groupingBy(
                                (Employee::getDepartment),
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println("Groupped employees by department: " + group_by_dept);


        Map<String, Long> count_emp_dept = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.counting()
                        )
                );

        System.out.println("Employees in each department: " + count_emp_dept);

        Map<String, Double> avg_sal_dept = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                )
        );

        System.out.println("Average sal in each dept: " + avg_sal_dept);

        Map<String, Integer> sum_sal_dept = employees.stream()
                .collect(Collectors.groupingBy(
                        (Employee::getDepartment),
                        Collectors.summingInt(Employee::getSalary)
                ));

        System.out.println("Sum of sal's in each department : " + sum_sal_dept);


        //sort the employees based on the salary
        List<String> sort_emp_names = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary)).map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("Sorted employees based on salary : " + sort_emp_names);


        //In-reverse order
        List<String> sort_emp_names_rev = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed()).map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("Reverse : Sorted employees based on salary: " + sort_emp_names_rev);

        //Find the second highest salary

        Optional<Integer> sec_high_sal = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary))
                .map(Employee::getSalary).skip(1).limit(1).findFirst();

        //Find hightest salary

        Optional<Employee> find_high_sal = employees.stream().max(Comparator.comparingInt(Employee::getSalary));

        List<String> strings = List.of("a","b","c","a","b","a");

        Map<String, Long> freq1 = strings.stream().collect(
                Collectors.groupingBy(
                        s -> s,
                        Collectors.counting()
                )
        );

        System.out.println("Frequency of each string: " + freq1);

        String str1 = "Hunter X Hunter Gon Save Killua Killua Save Gon Gon Follows Killua Killua Follows Gon";

        //Find the frequency of each word in that string

        Map<String, Long> freq2 = Arrays.stream(str1.split(" "))
                .collect(
                        Collectors.groupingBy(
                                s -> s,
                                Collectors.counting()
                        )
                );

        System.out.println("Frequency of each word in string : " + freq2);

        //Find each character count in the string

        List flat_list = Arrays.stream(str1.split(" ")).flatMap(
                w -> Arrays.stream(w.split(""))
        ).collect(Collectors.toList());

        System.out.println("Flat list: " + flat_list);

        Map<String, Long> freq3 = Arrays.stream(str1.split(" ")).flatMap(
                w -> Arrays.stream(w.split(""))
        ).map(c -> String.valueOf(c).toLowerCase())
                .collect(
                        Collectors.groupingBy(
                                c -> c,
                                Collectors.counting()
                        )
                );

        System.out.println("Total frequency of charactes in the string : " + freq3);

        Optional<Character> find_non_repeat_char = str1.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                c -> c,
                                LinkedHashMap::new,
                                Collectors.counting()
                        )
                ).entrySet()
                .stream().
                filter(e -> e.getValue() == 1)
                .map(e -> e.getKey())
                .findFirst();

        System.out.println("First non-repeating character: " + find_non_repeat_char);

    }
}
