// import java.util.*;
// public class NoOfPairs{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int t=sc.nextInt();
        

//         int c=0;
//         while(c<t){
//             int totalPairs=0;
//             int n=sc.nextInt();
//             int l=sc.nextInt();
//             int r=sc.nextInt();
//             int[] arr = new int[n];
//             for(int k=0; k<n;k++){
                
//                 arr[k]=sc.nextInt();
//             }
//             for(int i=0; i< n;i++ ){
                
//                 for(int j=i+1; j<n; j++){
//                     if((arr[i]+arr[j]<=r)&& (arr[i]+arr[j]>=l)){
//                         totalPairs+=1;
//                     }
//                 }
//             }
//             c++;
//             System.out.println(totalPairs);
//         }
//     }
// }

import java.util.*;

public class NoOfPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            long ans = countPairs(arr, r) - countPairs(arr, l - 1);
            System.out.println(ans);
        }
    }

    static long countPairs(int[] arr, int X) {
        int i = 0, j = arr.length - 1;
        long cnt = 0;

        while (i < j) {
            if (arr[i] + arr[j] <= X) {
                cnt += (j - i);
                i++;
            } else {
                j--;
            }
        }
        return cnt;
    }
}
