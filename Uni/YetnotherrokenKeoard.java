// CodeForces 1907B
// ARaBbbitBaby - ity 
// Solve this using 2 Stacks. our current sol is O(n2). with stack it will be O(n)

import java.util.Scanner;

public class YetnotherrokenKeoard {
    static StringBuilder removeb(StringBuilder sb) {
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (Character.isLowerCase(sb.charAt(i))) {
                sb.deleteCharAt(i);
                break;
            }
        }
        return sb;
    }

    static StringBuilder removeB(StringBuilder sb) {
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (Character.isUpperCase(sb.charAt(i))) {
                sb.deleteCharAt(i);
                break;
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        while (n > 0) {
            char ch = sc.next().charAt(0);
            n--;
            if (ch != 'B' && ch != 'b') {
                sb.append(ch);
            }
            if (ch == 'b') {
                sb = removeb(sb);
            }
            if (ch == 'B') {
                sb = removeB(sb);
            }
        }
        System.out.println(sb.toString());
        sc.close();
    }
}
