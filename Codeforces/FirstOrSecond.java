import java.util.*;

public class FirstOrSecond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long sum = 0;
            long minAbs = Long.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                long a = sc.nextLong();
                long abs = Math.abs(a);
                sum += abs;
                minAbs = Math.min(minAbs, abs);
            }

            System.out.println(sum - minAbs);
        }
    }
}
