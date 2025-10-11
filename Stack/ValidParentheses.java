
import java.util.Stack;

public class ValidParentheses {

    boolean Check(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char ch = stack.peek();
                stack.pop();

                if ((s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == ']' && ch == '[') || (s.charAt(i) == '}' && ch == '{')) {

                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// TC : O(n)
// SC: O(n)