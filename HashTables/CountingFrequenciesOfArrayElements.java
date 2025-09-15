import java.util.*;

public class CountingFrequenciesOfArrayElements {
    public static List<List<Integer>> countFrequencies(int[] nums) {
        // Your code goes here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int currentCount = map.get(nums[i]);
                map.put(nums[i], currentCount + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            List<Integer> pair = new ArrayList<>();
            pair.add(entry.getKey());
            pair.add(entry.getValue());
            result.add(pair);
        }

        return result;
    }

    public static void main(String[] args) {

        int nums[]={1,2,2,1,3};
        System.out.println(countFrequencies(nums));
    }
}
