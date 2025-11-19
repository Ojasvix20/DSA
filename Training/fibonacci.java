import java.util.*;

public class fibonacci {
    public static long fib(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(fib(sc.nextInt()));
    }
}
