import java.io.*;
import java.util.*;

public class DistinctValuesSubarrays {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        int l = 0, r = 0;
        long ans = 0;

        while (r < n) {
            if (!set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
                ans += (r - l);

            } else {
                set.remove(arr[l]);
                l++;
            }
        }

        System.out.println(ans);
    }
}
