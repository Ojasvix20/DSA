import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int turn =0;
        int sereja=0;
        int dima=0;
        int left=0, right = arr.length-1;


        for(int i=0; i<arr.length;i++){
            if (turn==0) {
                if(arr[right]> arr[left]){
                    sereja += arr[right];
                    right--; 
                }else{
                    sereja += arr[left];
                    left++;
                }
                turn =1;
            }
            else if (turn==1) {
                if(arr[right]> arr[left]){
                    dima += arr[right];
                    right--; 
                }else{
                    dima += arr[left];
                    left++;
                }
                turn=0;
            }
        }
        sc.close();

        System.out.println(sereja + " " + dima);

    }
}



// SHORTER VERSION (same complexity but shorter and competitive programming):

// import java.util.*;

// public class CardGame {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt(), a[] = new int[n];
//         for (int i = 0; i < n; i++) a[i] = sc.nextInt();

//         int l = 0, r = n - 1, s = 0, d = 0;
//         boolean turn = true; // true = Sereja, false = Dima

//         while (l <= r) {
//             int pick = (a[l] > a[r]) ? a[l++] : a[r--];
//             if (turn) s += pick; else d += pick;
//             turn = !turn;
//         }
//         System.out.println(s + " " + d);
//     }
// }
