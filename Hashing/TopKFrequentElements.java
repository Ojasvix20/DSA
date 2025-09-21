import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        // int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        // while (k > 0) {
        //     int maxKey = nums[0];
        //     int maxFreq = 0;

        //     for (int key : map.keySet()) {
        //         int freq = map.get(key);
        //         if (freq > maxFreq) {
        //             maxFreq = freq;
        //             maxKey = key;
        //         }
        //     }
        // }
        return map.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // sort by freq desc
                .limit(k)
                .mapToInt(Map.Entry::getKey) // get keys as int
                .toArray(); // collect into int[]
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
