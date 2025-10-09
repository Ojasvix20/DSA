import java.util.Stack;

public class QueueUsingStack {
    // We need 2 stacks to implement a queue
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // method to push: 1. all elements from s1 to s2. 2.Push element to s1. 3. Add
    // back elements from s2 to s1;

    // TC: O(2n)

    void push(int x) {

        // 1. all elements from s1 to s2.
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        // 2. add new elemnt to s1.
        s1.push(x);

        // 1. all elements back from s2 to s1.
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }

    int pop() {
        if (s1.isEmpty())
            return -1;

        return s1.pop();
    }

    int top() {
        if (s1.isEmpty())
            return -1;
        return s1.peek();
    }

}
