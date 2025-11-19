import java.util.Scanner;

public class Print1toN {
    public static void PrintN(int n) {
        if (n == 0) {
            return;
        }
        PrintN(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrintN(n);
        
    }
}
