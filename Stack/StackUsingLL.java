
public class StackUsingLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;
    int currSize = 0;

    boolean isEmpty() {
        return (top == null);
    }

    void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
        currSize++;

    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }
        Node PopNode = top;
        top = top.next;
        PopNode.next = null;
        currSize--;
        return PopNode.data;
    }

    int size() {
        return currSize;
    }

    public static void main(String[] args) {
        StackUsingLL st = new StackUsingLL();
        st.push(10);
        st.push(20);
        st.push(30);

    }
}
