public class Encapsulation {

    /*
        Encapsulation is the very important OOPS principle: It refers to the
        binding or bundling of the data + methods into one single unit called class
        It is also called as data hiding.

        - By declaring the object components such as instance variables using private
        we can hide the data.
        - By restricting the access to the object components using only getter and setter methods.

        Advantages of Encapsulation:
        - Security, Flexibility, Reusability
     */

    //Private Instances

    private int age;
    private String name;
    private int marks;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    //Note: we have packed all the variables and methods inside once class by restricting the access.
}
