import java.util.HashMap;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (Integer value : map.values()) {
            if (value != null && value % 2 != 0) { // Check for null and oddness
                odd++;
            }
        }
        if (odd > 1) {
            System.out.println("NO SOLUTION");
            return;
        }

        int l = 0, r = str.length() - 1;

        char[] arr = new char[str.length()];

        for (var entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            while (value >= 2) {
                arr[l] = key;
                arr[r] = key;
                l++;
                r--;
                value -= 2;
            }

            if (value == 1) {
                arr[str.length() / 2] = key;
            }
        }
        String palindrome = new String(arr);
        System.out.println(palindrome);

        return;
    }
}
