public class QueueUsingArray {
    int front = -1;
    int rear = -1;
    int size = 10;
    int[] arr = new int[size];
    int currSize = 0;

    boolean isFull() {
        return currSize == size;
    }

    boolean isEmpty() {
        return currSize == 0;
    }

    void push(int x) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        if (front == -1) {
            front = 0; // first element
        }

        rear = (rear + 1) % size;
        currSize++;
        arr[rear] = x;
        System.out.println(x + " pushed to queue");
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Underflow!");
            return;
        }

        int toPop = arr[front];
        front++;
        currSize--;
        System.out.println(toPop + " removed from queue");

        // Reset if queue becomes empty
        if (front > rear) {
            front = rear = -1;
        }
    }

    void peek() {
        if (isEmpty()) {
            System.out.println("Queue Empty!");
            return;
        }
        System.out.println("Queue Top: " + arr[front]);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }

        System.out.print("Queue: ");
        int i = front;
        for (int count = 0; count < currSize; count++) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size; // circular traversal
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray();
        q.push(10);
        q.push(20);
        q.push(30);
        q.display();
        q.pop();
        q.display();
        q.peek();
        q.pop();
        q.pop();
        q.display();
        q.pop();
        q.pop();
    }
}
