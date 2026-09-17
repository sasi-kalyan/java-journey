
/*
    Functional Interfaces: These are interfaces which contain only one abstract method but it can contains
    multiple default and static methods, this kind
    of interfaces were first introduced in LISP programming language.
    Functional Interfaces:

    Predicate<T> --> boolean
    Consumer<T>  --> void
    Supplier<T>  --> T
    Function<T>  --> R
    Comparator<T,T> --> int
    Runnable () --> void
 */

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
/*
    * Functional Interface: is an interface which does contain single ABSTRACT method, multiple default and static methods
    *
    * Predicate<T> - test
    * Function<T, R> - apply
    * Supplier<T> - get
    * Consumer<T> - accept
    * Comparator<T,T>
    * Runnable<T> - run

 */

public class FunctionalInterfacesExample {
    public static void main(String[] args) {

        //Predicate usage and example
        System.out.println("Predicate<T> Example");
        Predicate<Integer> iseven = (n) -> (n%2 == 0);
        Predicate<Integer> isodd  = (n) -> (n%2 != 0);

        System.out.println("2 is even & odd? " + iseven.and(isodd).test(2));
        System.out.println("5 is odd? " + isodd.test(5));
        System.out.println("8 is even? "+ iseven.test(8));

        //Supplier usage and examples
        Supplier<Integer> supp = () -> 100;

        System.out.println("100 value is being supplie " + supp.get());

        //Consumer usage and examples
        Consumer<String> con = (str) -> System.out.
                println("value consumed: "+ str);

        con.accept("Hunter X Hunter");

        //Function usage and example
        Function<Integer, Integer> fun = (a) -> (a * 4);
        System.out.println("value transformed: "+ fun.apply(100));

        //Comparator usage and examples
        Comparator<Integer> comp = (a, b) -> {
            if(a > b){
                return a;
            }
            return b;
        };

        System.out.println("a is greater or b? " + comp.compare(10, 1));

        Runnable runnable = () -> System.out.println("process running");
        runnable.run();
    }
}
