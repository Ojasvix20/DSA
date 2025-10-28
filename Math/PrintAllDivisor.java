
import java.util.ArrayList;
import java.util.Collections;

public class PrintAllDivisor {

    static void divisors(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                arr.add(i);
                if (n / i != i) {
                    arr.add(n / i);
                }
            }
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        divisors(36);
        // TC : O(root(n)) + nlogn + n
    }
}
