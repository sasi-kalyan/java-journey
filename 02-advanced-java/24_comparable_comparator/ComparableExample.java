import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Comparable is used for the Natural Sorting
    Comparable comes from the package java.lang.Comparable
    Comparable is an interface it contains single method compareTo

 */

class Student implements Comparable<Student>{
    private int rollNo;
    private String name;
    private int marks;

    public Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.rollNo - o.rollNo;
    }
}

public class ComparableExample{
    public static void main(String[] args) {
        Student s1 = new Student(1, "Naruto", 100);
        Student s2 = new Student(4, "Tanjiro", 90);
        Student s3 = new Student(3, "Gabimaru", 40);

        List<Student> students = new ArrayList<>(Arrays.asList(s1, s2, s3));
        Collections.sort(students);

        //after sort
        System.out.println("After sort: "+ students);
    }
}


