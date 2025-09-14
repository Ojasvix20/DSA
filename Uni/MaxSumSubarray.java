import java.util.ArrayList;
import java.util.Scanner;

public class MaxSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int i = 1;
        int i_copy = i;
        int j = k;
        int j_copy = j;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int j2 = 0; j2 < k; j2++) {
            sum += arr[j2];
        }
        list.add(sum);

        while (j < n) {
            int temp = sum - arr[i - 1] + arr[j];
            list.add(temp);
            if (temp > sum) {
                sum = temp;
                i_copy = i;
                j_copy = j;
            }
            i++;
            j++;
        }

        System.out.println(list);
        System.out.println(sum);
        System.out.println("w" + i_copy);
        System.out.println("Start: " + i_copy + ", End: " + j_copy);

    }
}
