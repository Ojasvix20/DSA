
import java.util.Stack;

public class QueueUsingStack {

    // We need 2 stacks to implement a queue
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // method to push: 1. all elements from s1 to s2. 2.Push element to s1. 3. Add
    // back elements from s2 to s1;
    // TC: O(2n) --- not EFFICIENT, consider approach 2 
    // void push(int x) {
    //     // 1. all elements from s1 to s2.
    //     while (!s1.isEmpty()) {
    //         s2.push(s1.pop());
    //     }
    //     // 2. add new elemnt to s1.
    //     s1.push(x);
    //     // 1. all elements back from s2 to s1.
    //     while (!s2.isEmpty()) {
    //         s1.push(s2.pop());
    //     }
    // }
    // int pop() {
    //     if (s1.isEmpty())
    //         return -1;
    //     return s1.pop();
    // }
    // int top() {
    //     if (s1.isEmpty())
    //         return -1;
    //     return s1.peek();
    // }
    // APPROACH 2
    void push(int x) {
        s1.push(x);     // s1= 2 3 4 5
    }

    int pop() {
        if (s2.isEmpty()) {     //true
            while (!s1.isEmpty()) {
                s2.push(s1.pop());      //s2= 5 4 3 2      
            }
        }
        if (!s2.isEmpty()) {
            return s2.pop();    // 2 is popped out
        }
        return -1; // if queue is empty
    }

    int top() {
        if (s2.isEmpty()) {             //
            while (!s1.isEmpty()) {
                s2.push(s1.pop());  
            }
        }
        return s2.peek();       // 3

    }

}
