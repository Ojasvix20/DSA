import java.util.Arrays;
import java.util.HashMap;

public class Find_Pair_Given_Difference {

    public static boolean findDifferencePair(int[] nums, int diff, HashMap<Integer, Integer> map) {
        Boolean present = false;
        for (int i = 0; i < nums.length; i++) {
            int plus = nums[i] + diff; // candidate for arr[i] + x
            int minus = nums[i] - diff; // candidate for arr[i] - x

            if (map.containsKey(plus) || map.containsKey(minus)) {
                present = true;
                return present;
            }
            map.put(nums[i], i);
        }
        return present;
    }

    // hashmap approach
    // public static void main(String[] args) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // int[] nums = { 1, 4, 9, 78, 6, 80, 2, 54, 7 };
    // int diff = 78;
    // System.out.println(findDifferencePair(nums, diff, map));
    // }

    public static void main(String[] args) {
        int[] nums = { 99, 48, 85, 49, 72, 65, 14, 76, 46, 13, 47, 79, 70, 63, 20, 86, 90, 45, 66, 41, 46, 9, 19 };
        Arrays.sort(nums);
        // [1, 2, 4, 6, 7, 9, 54, 78, 80]
        int diff = 19;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[right] - nums[left] > diff) {
                right--;
            } else if (nums[right] - nums[left] < diff) {
                left++;
            } else if (nums[right] - nums[left] == diff) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);

    }
}
