import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIExample {

    static class Employee{
        String name;
        int age;
        double salary;
        String department;

        Employee(String name, int age, double salary, String department){
            this.name = name;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    ", department='" + department + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 25, 50000, "IT"),
                new Employee("Bob", 35, 75000, "HR"),
                new Employee("Charlie", 28, 68000, "IT"),
                new Employee("David", 42, 90000, "Finance"),
                new Employee("Eve", 31, 55000, "HR"),
                new Employee("Frank", 29, 65000, "IT"),
                new Employee("Grace", 38, 80000, "Finance")
        );

        //Filter all the list of employees who are in the IT, >60000
        List<String> itEmpList = employees.stream().filter(e -> e.department.equals("IT")).
        filter(e -> e.salary > 60000).map(e -> e.name).collect(Collectors.toList());

        //Highest Paid employees
        Employee highPay = employees.stream().max(Comparator.comparing(e -> e.salary)).orElse(null);
        System.out.println(highPay);
        itEmpList.forEach(System.out::println);


        //Group by department
        Map<String, List<Employee>> bydept = employees.stream().
                collect(Collectors.groupingBy(e -> e.department));
        bydept.forEach((dept, list) -> {
            System.out.println(dept+" "+list.size());
        });
    }
}
