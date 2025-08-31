import java.util.Arrays;

public class Array_Leaders {
    public static int[] replaceElements(int[] arr) {
        int maxRight = -1; // Last element should always become -1

        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i]; // Save current element
            arr[i] = maxRight; // Replace with max so far
            maxRight = Math.max(maxRight, temp); // Update max
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 17, 18, 5, 4, 6, 1 };
        System.out.println(Arrays.toString(replaceElements(arr)));
    }
}
