import java.util.*;

public class PrintEvenIndices{
    public static void printEvenRev(int n, int[] arr){
        int i=n-1;
        while(i>0){
            if(i%2==0){
                System.out.print(arr[i]+ " ");
            }
            i--;
        }
        if(i==0){
            System.out.print(arr[i]);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n;i++){
            arr[i]=sc.nextInt();
        }

        printEvenRev(n, arr);
    }
}