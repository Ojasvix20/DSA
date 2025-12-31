
import java.util.Scanner;

public class Books {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int l = 0, r = 0;
        int totalBooks = 0, currSum = 0;
        while (r < n) {
            currSum += arr[r];      // add right
            r++;
            while (currSum > t) {   // if we cross freetime available
                currSum -= arr[l]; //   remove book
                l++;
            }
            totalBooks = Math.max(totalBooks, r - l);
        }
        System.out.println(totalBooks);
        sc.close();
    }
}
