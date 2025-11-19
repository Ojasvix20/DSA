import java.util.*;
import java.util.Stack;

public class NumberofGreaterElementstotheRight {
    public static List<Integer> count_NGE(int[] arr, int[] indices) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        List<Integer> result = new ArrayList<>();

        for (int idx : indices) {
            int count = 0;
            int val = arr[idx];

            // Count elements greater than arr[idx] to its right
            for (int j = idx + 1; j < arr.length; j++) {
                if (arr[j] > val) {
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }
}
