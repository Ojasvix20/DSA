
import java.util.Stack;

class Pair<U, V> {

    public final U first;
    public final V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

public class MinStack {

    // Stack<Pair<Integer, Integer>> st = new Stack<>();
    // void push(int x) {
    //     if (st.isEmpty()) {
    //         st.push(new Pair<>(x, x));
    //     } else {
    //         st.push(new Pair<>(x, Math.min(x, st.peek().second)));
    //     }
    // }
    // int pop() {
    //     if (!st.isEmpty()) {
    //         return (st.pop()).first;
    //     }
    //     return -1;
    // }
    // int top() {
    //     return st.peek().first;
    // }
    // int Min() {
    //     return st.peek().second;
    // }
    // The Above method has O(1) Tc but SC is O(2n)
    // we need to reduce Sc to O(n)
    int min = 0;
    Stack<Integer> st = new Stack<>();

    void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min = val;
        } else {
            {
                if (val > min) {
                    st.push(val);
                } else {
                    st.push(2 * (val) - min);
                    min = val;
                }
            }
        }
    }

    void pop() {
        if (st.isEmpty()) {
            return;
        }
        int n = st.peek();
        st.pop();

        if (n < min) {
            min = 2 * min - n;
        }
    }

    int top() {
        if (st.isEmpty()) {
            return -1;
        }
        int n = st.peek();
        if (min < n) {
            return n;
        }
        return min;
    }

    int getMin() {
        return min;
    }
    // TC: O(1)
    // SC: O(n)
}
