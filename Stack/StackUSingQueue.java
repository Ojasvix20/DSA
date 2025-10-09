import java.util.LinkedList;
import java.util.Queue;

public class StackUSingQueue {
    Queue<Integer> q = new LinkedList<>();
    int s = 0;

    boolean isEmpty() {
        return q.isEmpty();
    }

    void push(int x) {
        s = q.size();
        q.push(x);
        for (int i = 0; i < s; i++) {
            q.push(q.top());
            q.pop();
        }
    }

    void pop() {
        if (!q.isEmpty()) {
            q.pop();
        }
    }

    int top() {
        if (!q.isEmpty()) {
            return q.peek();
        }
    }
}
