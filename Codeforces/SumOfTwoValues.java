import java.util.*;

public class SumOfTwoValues {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int need = t - arr[i];

            if (map.containsKey(need)) {
                // +1 for 1-based indexing
                System.out.println((map.get(need) + 1) + " " + (i + 1));
                return;
            }

            // store current value and its index
            map.put(arr[i], i);
        }

        System.out.println(-1);
    }
}
