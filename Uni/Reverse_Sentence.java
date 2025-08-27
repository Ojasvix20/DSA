// 3rd approach using 2 pointers

import java.util.Scanner;

public class Reverse_Sentence {

    // Utility fn - to reverse chars in-place of the already reversed array
    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        sc.close();

        char[] arr = s.toCharArray();

        reverse(arr, 0, arr.length - 1);

        int start = 0;
        for (int end = 0; end <= arr.length; end++) {
            if (end == arr.length || arr[end] == ' ') {
                reverse(arr, start, end - 1);
                start = end + 1;
            }
        }

        System.out.println(new String(arr));
    }

}
