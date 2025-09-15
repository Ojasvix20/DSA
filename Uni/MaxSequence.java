import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
        }

        int i=0, j=0,maxS=0;

        while(j<n){
            if(arr[j]==0){
                maxS=Math.max(maxS, j-i);
                i=j;
                i++;
                j++;
            }else{
                j++;
            }
        }
        System.out.println(maxS);
    }
}
