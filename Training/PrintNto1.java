import java.util.Scanner;

public class PrintNto1 {
    public static void PrintN(int n) {
        if (n == 0) {
            return;
        }
        if(n==1){
            System.out.print(n);
        }else{
            System.out.print(n);
            System.out.print(" ");
        }
        PrintN(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrintN(n);
        
    }
}
