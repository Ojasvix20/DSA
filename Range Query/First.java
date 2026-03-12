import java.util.*;

public class First{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int q= sc.nextInt();

        int[] arr = new int[n];
        int[] preCal= new int[n];

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            preCal[i]=(i==0) ? arr[i] : preCal[i-1]+arr[i];
            
        }

        while(q-->0){
            int l= sc.nextInt();
            int r= sc.nextInt();
            if(l==0){
                System.out.println(preCal[r]);
            }else
                System.out.println(preCal[r]-preCal[l-1]);
        }


    }
}