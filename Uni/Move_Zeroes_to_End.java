import java.util.Arrays;

public class Move_Zeroes_to_End {
    public static void moveZeroes(int[] nums) {

        int n = nums.length;
        int insertPos = 0;

        for (int i = 0; i < n; i++) { // copy non-zero elements to the front
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // now fill remaining with zeroes:
        for (int i = insertPos; i < n; i++) {
            nums[i] = 0;
        }

        // return nums; not needed, void return type
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = { 5, 0, 4, 0, 2, 1, 0, 3, 6, 5, 0 };
        moveZeroes(nums);
    }
}
