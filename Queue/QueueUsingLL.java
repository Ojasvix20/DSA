
public class QueueUsingLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node start = null, end = null;
    int currSize = 0;

    boolean isEmpty() {
        return (end == null && start == null);
    }

    void push(int x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            start = end = newNode;
        } else {
            end.next = newNode;
            end = newNode;
        }
        currSize++;
    }

    int pop() {
        if (isEmpty()) {
            return -1;
        }
        Node temp = start;
        start = start.next;
        currSize--;
        temp.next = null;
        if (start == null) {
            end = null;
        }
        return temp.data;

    }

    int top() {
        if (isEmpty())
            return -1;
        return start.data;
    }

    void display() {
        System.out.print("Queue: ");
        Node temp = start;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingLL q = new QueueUsingLL();

        q.push(5);
        q.push(47);
        q.push(8);
        q.push(4);
        q.push(55);
        q.display();

        q.pop();
        q.display();

    }
}
