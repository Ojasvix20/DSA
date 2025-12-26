import java.io.*;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int i = 0, j = n - 1;
        int gondolas = 0;

        while (i <= j) {
            if (arr[i] + arr[j] <= x) {
                i++;   // pair lightest & heaviest
            }
            j--;       // heaviest always boards
            gondolas++;
        }

        System.out.println(gondolas);
    }
}
