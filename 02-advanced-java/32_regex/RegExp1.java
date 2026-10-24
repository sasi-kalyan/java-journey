import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Regex: is the library that is used to find the matching strings/patterns in the strings

    two important classes:
    Pattern patt = Pattern.compile("<pattern>");
    Matcher mat = patt.matcher("<string>");

    methods:
    - find -> that finds the substr exists in the string
    - matches -> it needs entire string to match
    - group - that gives the matched group of chars
 */

public class RegExp1 {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("cat");
        Matcher matcher = pattern.matcher("cat");

        System.out.println(matcher.find());
        System.out.println(matcher.matches());

        //group method using []

        //Pattern p2 = Pattern.compile("[^A-Za-z0-9]");
        //Pattern p2 = Pattern.compile("[0-9]{2,4}");
        Pattern p2 = Pattern.compile("[A-Z]*");
        Matcher m2 = p2.matcher("_JavA123");

        while (m2.find()){
            System.out.print(m2.group() + " ");
        }
    }
}
