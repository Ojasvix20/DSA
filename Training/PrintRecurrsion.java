import java.util.Scanner;

public class PrintRecurrsion {
    public static void Print(int n) {
        if (n == 0) {
            return;
        }
        Print(n - 1);
        System.out.println("I love Recursion");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Print(n);
        
    }
}
