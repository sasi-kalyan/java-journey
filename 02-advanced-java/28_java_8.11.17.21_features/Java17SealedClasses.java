
/*
    Sealed classes are the new feature introduced in java-17,
    the class which restrict the classes to allow and implement
    the methods defined inside it.
 */
sealed class Shape
    permits Circle, Triangle, Rectangle{

    double PI = 3.14;
}

final class Circle extends Shape{
    double radius;
}

final  class Triangle extends Shape{
    double a,b,c;
}

non-sealed class Rectangle extends Shape{
    double l, b;
}

public class Java17SealedClasses {
    public static void main(String[] args) {

    }
}
