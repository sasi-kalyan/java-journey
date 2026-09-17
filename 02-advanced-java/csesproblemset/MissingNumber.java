import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long sum = 0;
        for (long i = 0; i < n - 1; i++) {
            sum += sc.nextInt();
        }
        long sumofn = ((n * (n + 1)) / 2);
        System.out.println(sumofn - sum);

    }
}