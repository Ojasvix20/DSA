
import java.io.*;
import java.util.*;

public class Playlist {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> set = new HashSet<>();
        int l = 0, r = 0, maxLen = 0;

        while (r < n) {
            if (!set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
                maxLen = Math.max(maxLen, r - l);
            } else {
                set.remove(arr[l]);
                l++;
            }
        }

        System.out.println(maxLen);
    }
}

// import java.util.*;

// public class Playlist {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             arr[i] = sc.nextInt();
//         }
//         HashSet<Integer> set = new HashSet<>();
//         int l = 0, r = 0;
//         int len=0;
//         int maxLen = Integer.MIN_VALUE;
//         while (r < n) {
            
//             if (!set.contains(arr[r])) {
//                 set.add(arr[r]);
//                 r++;
//                 maxLen = Math.max(maxLen, r - l);
//             }else{
//                 set.remove(arr[l]);
//                 l++;
//             }
            

//         }
//         System.out.println(maxLen);

//         sc.close();
//     }
// }
