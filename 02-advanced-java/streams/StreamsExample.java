import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsExample {

    /*
        Streams in java is introduced in Java-8, It is used to process the collections (or other data sources)
        in functional, declarative style.

        Data Source --> Stream --> Intermediate Operations ---> Terminal Operations --> Result
     */
    public static void main(String[] args) {

        List<String> anime = new ArrayList<>(Arrays.asList("Naruto", "Death Note", "Hell's Paradise", "Your Name"));

        Stream<String> stream1 = anime.stream();
        Stream<String> stream2 = anime.parallelStream();

        //From Arrays
        String[] arr = {"A", "B", "C"};
        Stream<String> stream = Arrays.stream(arr);

        //From Values
        Stream<Integer> nums = Stream.of(1, 2, 4, 5, 6);


        //Infinite streams
        Stream<Double> random = Stream.generate(Math::random);
        Stream<Integer> integerStream = Stream.iterate(0, n -> n+1);

    }
}
