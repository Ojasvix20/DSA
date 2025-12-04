import java.util.*;

public class LowOrHigh {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        generate("", n);
        
        // Print result
        for (String s : result) {
            System.out.println(s);
        }
    }

    static void generate(String curr, int n) {
        // Base case
        if (curr.length() == n) {
            result.add(curr);
            return;
        }

        // put L
        generate(curr + "L", n);

        // put H
        generate(curr + "H", n);
    }
}
