package practice;

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

    public int getSalary() {
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

public class EmployeeQuestions {

    public static void main(String[] args) {
        List<Employee> employees = List.of(

                new Employee(1L, "John", "IT", 75000, 28, "Male"),
                new Employee(2L, "Sarah", "HR", 65000, 32, "Female"),
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

        //System.out.println("List of all employees: " + employees);

        //Find all IT employees.
        List<Employee> itEmp = employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .collect(Collectors.toList());
        System.out.println("IT employees: " + itEmp);

        //Find employees earning > 80000.
        List<String> gt80K = employees.stream().filter(e -> e.getSalary() > 80000)
                .map(Employee::getName).collect(Collectors.toList());
        System.out.println("Employees list earning > 80K : " + gt80K);

        //Find total employee count
        long countEmp = employees.stream().count();
        System.out.println("Count of employees: " + countEmp);

        //Find average salary.
        OptionalDouble avgSal = employees.stream().mapToDouble(Employee::getSalary).average();
        System.out.println("average salary of employee: " + avgSal.orElse(0.0));

        //Find maximum salary employee.
        Optional<Employee> maxSal = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("Maximum salary of employees : " + maxSal.orElse(null));

        //Find youngest employee.
        Optional<Employee> youngEmp = employees.stream().
                min(Comparator.comparingInt(Employee::getAge));
        System.out.println("Youngest employee: " + youngEmp.orElse(null));

        //Group employees by department.
        Map<String, List<String>>
                groupEmpByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList()
                        )
                ));

        System.out.println("Grouped by Dept: " + groupEmpByDept);


        //Group employees by gender.

        Map<String, List<String>>
                groupByGender = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.mapping(
                                        Employee::getName,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println("Groupped by gender: " + groupByGender);

        Map<String, Long> countEmpByDept = employees.
                stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.counting()
                ));

        System.out.println("Count Employees by department : " + countEmpByDept);



        //Find department wise average salary.
        Map<String, Double> deptWiseAvgSal =
                employees.stream().collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );

        System.out.println("deptmentwise avg salary: " + deptWiseAvgSal);

        Map<String, Optional<Employee>>
                deptWiseMaxSal = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                            Comparator.comparingDouble(Employee::getSalary)
                                )
                        )
                );

        System.out.println("department wise max salary: " + deptWiseMaxSal);

    }
}
