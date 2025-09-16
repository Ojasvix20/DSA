// Return the max length of longest substring in which no character is repeating.

import java.util.HashMap;

class LongestSubstring {
    public static void main(String[] args) {
        String s = "bhibvgyygvftrseaw";
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            
            // store/update last seen index
            map.put(c, right);

            // calculate window length
            maxLen = Math.max(maxLen, right - left + 1);
        }

        System.out.println(maxLen);

    }
}
