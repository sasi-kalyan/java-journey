import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {
    public static void main(String[] args) {

        //Stream<Integer> st1 = Stream.iterate(0, n->n+1);
        //Stream<Double> st2 = Stream.generate(Math::random);
        //st2.forEach(n -> System.out.println(n + "-->"));

        //We can create streams like
        Stream<Integer> st1 = Stream.of(1 , 4, 5, 7, 9, 10);
        Stream<Integer> st2 = Stream.iterate(0, n -> n + 1); //infinite stream

        Stream<Double> st3 = Stream.generate(() -> Math.random());

        IntStream is = IntStream.rangeClosed(1, 5);
        is.forEach(n -> System.out.print(n+" "));

    }
}
