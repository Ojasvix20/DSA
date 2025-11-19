import java.util.Stack;

public class NextSmallerElement {
    public static int[] NGE(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            // Push current element for next iteration
            st.push(arr[i]);

        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 10, 8 };
        int[] result = NGE(arr);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}

