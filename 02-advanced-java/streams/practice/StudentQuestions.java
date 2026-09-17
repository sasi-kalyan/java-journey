package practice;


import java.util.List;

class Student{
    private Long id;
    private String name;
    private String department;
    private int marks;
    private int age;

    public Student(Long id, String name, String department, int marks, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.marks = marks;
        this.age = age;
    }
}
public class StudentQuestions {
    public static void main(String[] args) {
        List<Student> students = List.of(

                new Student(101L,"Rahul","CSE",91,22),
                new Student(102L,"Anjali","ECE",88,21),
                new Student(103L,"Kiran","CSE",76,23),
                new Student(104L,"Pooja","MECH",67,20),
                new Student(105L,"Varun","ECE",95,22),
                new Student(106L,"Teja","CSE",54,24),
                new Student(107L,"Sneha","MECH",82,21),
                new Student(108L,"Ravi","CIVIL",34,22),
                new Student(109L,"Priya","CSE",99,20),
                new Student(110L,"Aman","ECE",72,23),
                new Student(111L,"Harsha","MECH",45,21),
                new Student(112L,"Divya","CSE",89,23),
                new Student(113L,"Rohan","ECE",92,22),
                new Student(114L,"Nikhil","CIVIL",63,24),
                new Student(115L,"Megha","MECH",98,20)
        );
    }
}
