import java.util.Scanner;

public class Repetition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int i = 1, j = 0, count = 1, max = 1;

        while (i < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                j = i;
                count = 1;
            } else {
                count++;
            }
            max = Math.max(max, count);
            i++;
        }

        System.out.println(max);
    }
}
