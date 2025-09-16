import java.util.HashMap;
// import java.util.Collections;

public class MaxFreq {

    public static int mostFrequentElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // Integer maxVal = Collections.max(map.values());
        int maxKey = nums[0];
        int maxFreq = 0;

        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (freq > maxFreq) {
                maxFreq = freq;
                maxKey = key;
            }
        }

        return maxKey;

    }

    public static void main(String[] args) {
        int[] nums = { 4, 4, 5, 5, 6 };
        System.out.println(mostFrequentElement(nums));

    }

}


