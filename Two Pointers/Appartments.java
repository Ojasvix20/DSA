
// import java.util.*;
// // CSES

// public class Appartments {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int m = sc.nextInt();
//         int n = sc.nextInt();
//         int k = sc.nextInt();
//         int[] person = new int[m];
//         int[] appartments = new int[n];
//         for (int i = 0; i < m; i++) {
//             person[i] = sc.nextInt();
//         }
//         for (int i = 0; i < n; i++) {
//             appartments[i] = sc.nextInt();
//         }

//         int i = 0, j = 0, ans = 0;

//         Arrays.sort(person);
//         Arrays.sort(appartments);

//         while (i < m && j < n) {
//             if (Math.abs(person[i] - appartments[j]) <= k) {
//                 ans++;
//                 i++;    // move both
//                 j++;
//             } else if (appartments[j] < person[i] - k) {
//                 j++;    // apartment too small
//             } else {
//                 i++;    // apartment too big
//             }
//         }
//         System.out.println(ans);
//         sc.close();
//     }

// }

import java.io.*;
import java.util.*;
// CSES

public class Appartments {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] person = new int[m];
        int[] appartments = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            appartments[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(person);
        Arrays.sort(appartments);

        int i = 0, j = 0, ans = 0;

        while (i < m && j < n) {
            if (Math.abs(person[i] - appartments[j]) <= k) {
                ans++;
                i++;
                j++;
            } else if (appartments[j] < person[i] - k) {
                j++;
            } else {
                i++;
            }
        }

        System.out.println(ans);
    }
}
