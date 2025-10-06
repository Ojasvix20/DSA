public class StackUsingArray {
    int top = -1;
    int arr[] = new int[10];

    boolean isFull() {
        return top == arr.length - 1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        } else {
            top += 1;
            arr[top] = x;
        }
    }

    int top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return arr[top];
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int toPop = arr[top];
        top--;
        return toPop;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();
        stack.push(69);
        stack.push(12);
        stack.push(55);
        stack.push(79);
        System.out.println("Stack Top: " + stack.top());
        System.out.println("Top element removed: " + stack.pop());
        System.out.println("New Top: " + stack.top());
    }

}