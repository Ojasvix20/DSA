
import java.util.Stack;

public class InfixPostFixPrefix {

    // Function to return precedence of operators
    int priority(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '^') {
            return 3;
        }
        return -1;
    }

    // Function to convert Infix to Postfix
    String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If operand, add to output
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                ans.append(ch);
            } // If '(' push to stack
            else if (ch == '(') {
                st.push(ch);
            } // If ')', pop until '('
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                if (!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                }
            } // If operator
            else {
                while (!st.isEmpty() && priority(ch) <= priority(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
        }

        // Pop remaining operators
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    String infixToPrefix(String s) {

    }

    String infixToPrefix(String s) {

    }

    // Test the conversion
    public static void main(String[] args) {
        InfixPostFixPrefix converter = new InfixPostFixPrefix();
        String infix = "A+(B*C-(D/E^F)*G)*H";
        System.out.println("Postfix: " + converter.infixToPostfix(infix));
    }
}
