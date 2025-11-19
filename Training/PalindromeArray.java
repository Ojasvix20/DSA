import java.util.*;

public class PalindromeArray {

    public static boolean isPalindrome(int[] arr, int left, int right) {
        // Base case: 
        if (left >= right) return true;

        if (arr[left] != arr[right]) return false;

        return isPalindrome(arr, left + 1, right - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (isPalindrome(arr, 0, n - 1)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
