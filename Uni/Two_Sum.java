import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// import java.util.Scanner;

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> h = new HashMap<>(); // using hashmap is the best approach having least time complexity =
                                                   // O(n)
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];

            if (h.containsKey(x)) {
                return new int[] { x, nums[i] }; // may return indexes depending upon the question
            }

            h.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        int[] nums = { 4, 3, 15, 8, 79, 6, 7, 5, 11, 32 };
        System.out.println(Arrays.toString(twoSum(nums, 21)));
    }
}

// two pointer approach O(nlogn - n for loop + nlogn for sorting) slower
// thanhashmap but faster thanbrute-force(nested loops O(n^2))

// public class Two_Sum {
// public static void main(String[] args) {

// int[] nums = { 4, 3, 15, 8, 79, 6, 7, 5, 11, 32 };
// int target = 21;
// Arrays.sort(nums);
// // nums[] becomes [3, 4, 5, 6, 7, 8, 11, 15, 32, 79]
// int left = 0;
// int right = nums.length - 1;
// while (left < right) {
// if (nums[left] + nums[right] > target) {
// right--;
// } else if (nums[left] + nums[right] < target) {
// left++;
// } else if (nums[left] + nums[right] == target) {
// System.out.println("pair found " + nums[left] + " + " + nums[right] + " = " +
// target);
// left++;
// right--;
// }
// }
// }
// }