package problems;

import java.util.*;
import java.util.stream.Collectors;

class Employee{
    int id;
    String name;
    int age;
    String department;
    double salary;
    String gender;
    int experience;
    boolean active;
    List<String> skills;
    List<String> projects;

    public Employee(int id, String name, int age, String department, double salary, String gender, int experience, boolean active, List<String> skills, List<String> projects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.gender = gender;
        this.experience = experience;
        this.active = active;
        this.skills = skills;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}

class Product{
    int id;
    String name;
    String categeory;
    double price;
    int quantity;
    double rating;

    public Product(int id, String name, String categeory, double price, int quantity, double rating) {
        this.id = id;
        this.name = name;
        this.categeory = categeory;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategeory() {
        return categeory;
    }

    public void setCategeory(String categeory) {
        this.categeory = categeory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}

class Student{
    int id;
    String name;
    int age;
    String grade;
    double gpa;
    String major;
    List<Integer> marks;
    boolean scholoarship;

    public Student(int id, String name, int age, String grade, double gpa, String major, List<Integer> marks, boolean scholoarship) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.gpa = gpa;
        this.major = major;
        this.marks = marks;
        this.scholoarship = scholoarship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public boolean isScholoarship() {
        return scholoarship;
    }

    public void setScholoarship(boolean scholoarship) {
        this.scholoarship = scholoarship;
    }
}

public class ObjectBasedStreamProblems {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(1, "John", 28, "IT", 75000, "Male", 5, true,
                        Arrays.asList("Java", "Spring", "SQL"),
                        Arrays.asList("BankingApp", "InsurancePortal")),

                new Employee(2, "Alice", 30, "HR", 65000, "Female", 7, true,
                        Arrays.asList("Recruitment", "Payroll"),
                        Arrays.asList("HRMS")),

                new Employee(3, "Bob", 35, "IT", 90000, "Male", 10, true,
                        Arrays.asList("Java", "Microservices", "AWS"),
                        Arrays.asList("LoanSystem", "Payments")),

                new Employee(4, "Mary", 27, "Finance", 70000, "Female", 4, true,
                        Arrays.asList("Excel", "Accounting"),
                        Arrays.asList("BudgetTracker")),

                new Employee(5, "David", 40, "IT", 120000, "Male", 15, true,
                        Arrays.asList("Architecture", "Spring Boot"),
                        Arrays.asList("CoreBanking")),

                new Employee(6, "Sophia", 26, "Marketing", 55000, "Female", 3, false,
                        Arrays.asList("SEO", "Analytics"),
                        Arrays.asList("CampaignManager")),

                new Employee(7, "James", 32, "Finance", 82000, "Male", 8, true,
                        Arrays.asList("Taxation", "Reporting"),
                        Arrays.asList("FinancePortal")),

                new Employee(8, "Emma", 29, "IT", 87000, "Female", 6, true,
                        Arrays.asList("React", "Java", "Spring"),
                        Arrays.asList("CRM", "CustomerPortal")),

                new Employee(9, "Michael", 38, "Operations", 78000, "Male", 12, false,
                        Arrays.asList("Operations", "Management"),
                        Arrays.asList("ERPSystem")),

                new Employee(10, "Olivia", 31, "HR", 68000, "Female", 7, true,
                        Arrays.asList("Recruitment", "Training"),
                        Arrays.asList("EmployeePortal"))
        );


        List<Product> products = Arrays.asList(

                new Product(101, "iPhone 15", "Electronics", 79999, 50, 4.8),
                new Product(102, "Samsung TV", "Electronics", 55000, 20, 4.6),
                new Product(103, "Laptop Dell", "Computers", 65000, 15, 4.7),
                new Product(104, "MacBook Air", "Computers", 95000, 8, 4.9),
                new Product(105, "Nike Shoes", "Fashion", 5000, 100, 4.5),
                new Product(106, "Levis Jeans", "Fashion", 2500, 75, 4.3),
                new Product(107, "Dining Table", "Furniture", 18000, 10, 4.1),
                new Product(108, "Office Chair", "Furniture", 7500, 25, 4.4),
                new Product(109, "Air Conditioner", "Appliances", 42000, 12, 4.6),
                new Product(110, "Washing Machine", "Appliances", 32000, 18, 4.2)
        );

        List<Student> students = Arrays.asList(

                new Student(1, "Kiran", 20, "A", 8.7, "Computer Science",
                        Arrays.asList(85, 88, 90, 92, 87), true),

                new Student(2, "Neha", 21, "A", 9.1, "Electronics",
                        Arrays.asList(90, 92, 95, 89, 91), true),

                new Student(3, "Rahul", 22, "B", 7.5, "Mechanical",
                        Arrays.asList(70, 75, 72, 80, 78), false),

                new Student(4, "Priya", 20, "A", 8.9, "Computer Science",
                        Arrays.asList(88, 86, 92, 91, 89), true),

                new Student(5, "Arjun", 23, "C", 6.8, "Civil",
                        Arrays.asList(65, 68, 70, 72, 66), false),

                new Student(6, "Sneha", 21, "B", 7.8, "Information Technology",
                        Arrays.asList(78, 80, 82, 76, 79), false),

                new Student(7, "Vikram", 22, "A", 9.3, "Computer Science",
                        Arrays.asList(93, 95, 94, 96, 92), true),

                new Student(8, "Pooja", 20, "B", 8.0, "Electronics",
                        Arrays.asList(80, 81, 79, 84, 82), true),

                new Student(9, "Rakesh", 24, "C", 6.5, "Mechanical",
                        Arrays.asList(60, 65, 68, 66, 64), false),

                new Student(10, "Ananya", 21, "A", 9.0, "Information Technology",
                        Arrays.asList(89, 91, 90, 93, 88), true)
        );


        //1. Get all active emps
        List<String> activeEmps = employees.stream()
                .filter(Employee::isActive).map(Employee::getName).collect(Collectors.toList());
        System.out.println(activeEmps);

        //2. get employees in IT dept
        List<String> empIT = employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(empIT);

        //3. sort emp based on sal desc
        List<Double> empSalDesc = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getSalary)
                .collect(Collectors.toList());
        System.out.println(empSalDesc);

        //4. group emp by department
        Map<String, List<String>>
                groupByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(e->e.getName(),
                                Collectors.toList())
                ));

        System.out.println(groupByDept);

        Map<String, Long> countEmpByDept =
                employees.stream()
                        .collect(
                                Collectors.groupingBy(
                                        (Employee::getDepartment),
                                        Collectors.counting()
                                )
                        );

        System.out.println(countEmpByDept);

        Map<String, Double> avgSalByDept =
                employees.stream().collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(
                                        Employee::getSalary
                                )
                        )
                );

        System.out.println(avgSalByDept);

        Map<String, Optional<Employee>> findEmpSal
                = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(
                        Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(Employee::getSalary)
                                )
                        )
                );

        findEmpSal.values().forEach(
                v -> System.out.println(v.get().getName())
        );

        List<String> uniqueSkills =
                employees.stream().flatMap(e -> e.getSkills().stream()).distinct()
                        .collect(Collectors.toList());

        System.out.println("unique skills: "+ uniqueSkills);

        ;
    }
}
