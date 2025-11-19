
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> q = new LinkedList<>();
    int s = 0;

    boolean isEmpty() {
        return q.isEmpty();
    }

    void push(int x) {
        s = q.size();
        q.add(x);
        for (int i = 0; i < s; i++) {
            q.add(q.peek());
            q.remove();
        }
    }

    void pop() {
        if (!q.isEmpty()) {
            q.remove();
        }
    }

    int top() {
        if (!q.isEmpty()) {
            return q.peek();
        }
    }
}
