
import java.util.*;

public class PermutationInString {

    private static ArrayList<String> permutation(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i);

            ans.addAll(permutation(f + ch + s, up.substring(1)));
        }

        return ans;
    }

    public static void main(String[] args) {
        

        ArrayList<String> arr = permutation("", "ba");

        boolean present = false;
        for (int i = 0; i < arr.size(); i++) {
            if(s2.contains(arr.get(i)));
        }
    }
}
