import java.util.*;

public class WeirdAlgorithm{
    public static void WeirdAlgo(long n){
        System.out.print(n + " ");
        if(n==1){
            return;
        }

        if(n%2==0){
            WeirdAlgo(n/2);
        }else{
            WeirdAlgo((n*3)+1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long n= sc.nextInt();
        WeirdAlgo(n);
    }
}