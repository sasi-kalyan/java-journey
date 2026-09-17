
/*
        Super Keyword:
        - Super keyword refers to objects of immediate parent class
        - Super keyword is used to:
            - Access the parent class method
            - To call the parameterized constructor of parent class explicitly
            - To access the variables when the child class has same variable names
 */

class First{
    int val = 100;

    First(){
        System.out.println("parent default constructor");
    }

    First(int val){
        this.val = val;
    }

    public void method(){
        System.out.println("parent method");
    }
}

class Second extends First{

    int val = 900;

    Second(){
        super(10000); //invoking parent parameterized constrcutor
        System.out.println("inside child constructor");
    }

    public void method(){
        System.out.println("inside child method");
        super.method(); //invoking parent method
        System.out.println("child val: "+ val+" parent val: "+ super.val);
    }
}

public class SuperExample {
    public static void main(String[] args) {
        Second obj = new Second();
        obj.method();
    }
}
