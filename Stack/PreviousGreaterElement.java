import java.util.Stack;

public class PreviousGreaterElement {
    public static int[] PGE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] pge = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                pge[i] = -1;
            } else {
                pge[i] = st.peek();
            }

            // Push current element for next iteration
            st.push(arr[i]);

        }
        return pge;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        int[] result = PGE(arr);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
