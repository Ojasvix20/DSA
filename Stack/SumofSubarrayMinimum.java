import java.util.Stack;

public class SumofSubarrayMinimum {
    static int Sum(int arr[]) {
        int n = arr.length;
        int mod = (int) 1e9 + 7;

        long ans = 0;
        Stack<Integer> st = new Stack<>();

        int[] left = new int[n]; // distance to previous smaller
        int[] right = new int[n]; // distance to next smaller

        // Find pse
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i])
                st.pop();
            left[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        // Clear stack for next pass
        st.clear();

        // Find next smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i])
                st.pop();
            right[i] = st.isEmpty() ? (n - i) : (st.peek() - i);
            st.push(i);
        }

        // Calculate contribution
        for (int i = 0; i < n; i++) {
            long contribution = ((long) arr[i] * left[i] * right[i]) % mod;
            ans = (ans + contribution) % mod;
        }

        return (int) ans;
    }
}
