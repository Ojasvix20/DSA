import java.util.*;

public class ImpostOrSus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String r = sc.next();
            int n = r.length();

            // Required assertion
            for (char c : r.toCharArray()) {
                assert c == 's' || c == 'u';
            }

            int U = 0;
            for (char c : r.toCharArray()) {
                if (c == 'u') U++;
            }

            int maxKeptU = Math.min(U, (n - 1) / 2);
            int operations = U - maxKeptU;

            System.out.println(operations);
        }

        sc.close();
    }
}
