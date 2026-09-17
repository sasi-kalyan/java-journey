
class Student{
    protected int age;
    protected String name;

    Student(int age, String name){
        this.age = age;
        this.name = name;
    }

    Student(Student obj){   //copy of object details to another object
        this.age = obj.age;
        this.name = obj.name;
    }
}

public class CopyOfConstructor {
    public static void main(String[] args) {
        Student obj1 = new Student(23, "Kalyan");
        Student obj2 = new Student(obj1);

        System.out.println("Student 1, details");
        System.out.println(obj1.age);
        System.out.println(obj1.name);

        System.out.println("Student 2, details");
        System.out.println(obj2.age);
        System.out.println(obj2.name);
    }
}
