import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            int y = 0, n = 0;

            for (char c : s.toCharArray()) {
                if (c == 'Y') y++;
                else n++;
            }

            if (y <= n + 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
