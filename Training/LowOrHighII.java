import java.util.*;

public class LowOrHighII {

    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        generate("", n,'a');
        
        // Print result
        for (String s : result) {
            System.out.println(s);
        }
    }

    static void generate(String curr, int n, char prev) {
        // Base case
        if (curr.length() == n) {
            result.add(curr);
            return;
        }

        // // prev== L -> only H allowed now
        // if(prev=='L'){

        //     generate(curr + "H", n,'H');
        // }else{
        // // prev='H' -> put H or L - 2 choices
        // generate(curr + "H", n,'H');
        // generate(curr + "L", n,'L');
        // }

        generate(curr + "H", n,'H');
        if(prev!='L') generate(curr + "L", n,'L');

    }
}
