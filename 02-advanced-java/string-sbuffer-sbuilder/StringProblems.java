import java.util.Map;
import java.util.stream.Collectors;

public class StringProblems {

    public static void main(String[] args) {

        String str = "Hello World";
        String rev = new StringBuilder(str).reverse().toString();
        System.out.println("reversed string: " + rev);

        String str2 = "programming";

        long mc = str2.chars().filter(c -> c == 'm').count();
        System.out.println("cnt of m : "+ mc);

        Map<String, Long> ccount = str2.chars().mapToObj(
                c -> (char)c
        ).collect(
                Collectors.groupingBy(
                        c->String.valueOf(c),
                        Collectors.counting()
                )
        );

        System.out.println("character map: "+ ccount);

        String remDup = str2.chars().distinct().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
        System.out.println("removed duplicates: "+remDup);

        //check palindrome
        String k = "akaraka";
        boolean palindrome = new StringBuilder(k).reverse().toString().equals(k);
        System.out.println("isplaindrome? "+ palindrome);
    }
}
