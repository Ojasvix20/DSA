import java.util.*;

class MaxSequence_flipped {

    public static int longestOnes(int[] nums, int k) {
        int i = 0, j = 0;
        int n = nums.length;
        int zeroCount = 0;
        int len = 0;

        while (j < n) {
            if (nums[j] == 0) {
                zeroCount++;
            }

            // shrink window if too many zeros
            while (zeroCount > k) {
                if (nums[i] == 0) {
                    zeroCount--;
                }
                i++;
            }

            // update max length
            len = Math.max(len, j - i + 1);
            j++;
        }

        return len;

    }

    public static void main(String[] args) {
        int nums[] = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        System.out.println(longestOnes(nums, 3));
    }
}