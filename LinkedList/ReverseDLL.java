
import java.util.Stack;

;

public class ReverseDLL {

    static class Node {

        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node ArrayToDLL(int[] arr) {

        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
        }
        return head;
    }

    static void PrintDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.data + " <-> ");
            } else {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    static Node ReverseUsingStack(Node head) {
        // doing reversal using stack isnt efficient : TC: O(2n) ~ O(n) & SC: O(n).
        // same can be done via 2 pointers with same TC but constant SC: O(1)
        if (head == null) {
            return null;
        }
        Stack<Integer> s = new Stack<>();
        Node temp = head;

        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            temp.data = s.pop();
            temp = temp.next;
        }

        return head;
    }

    static Node ReverseUsing2Pointers(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node curr = head;
        Node last = null;

        while (curr != null) {
            last = curr.prev;
            curr.prev = curr.next;
            curr.next = last;
            curr = curr.prev;
        }
        return last.prev;
    }

    static Node ReverseRecurion(Node head) {
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = ArrayToDLL(arr);
        PrintDLL(head);

        // head = ReverseUsingStack(head);
        // PrintDLL(head);
        head = ReverseUsing2Pointers(head);
        PrintDLL(head);
    }
}
