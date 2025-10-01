
import java.util.ArrayList;

public class OddEven {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static Node arrayToLL(int[] arr) { // convert array to 1D Linked List
        Node head = new Node(arr[0]);
        Node curr = head;
        int j = 1;
        while (j < arr.length) {
            Node temp = new Node(arr[j]);
            curr.next = temp;
            curr = temp;
            j++;
        }
        return head;
    }

    static void printLL(Node head) {
        Node p = head;
        while (p != null) {
            if (p.next != null) {
                System.out.print(p.data + "->");
            } else {
                System.out.print(p.data);
            }
            p = p.next;
        }
        System.out.println();
    }

    static Node OddEvenBrute1(Node head) {
        // Not efficient, O(n) space complexity - creating new nodes
        // another ineffecient approach is to use array to get odd and even nodes separed then make a new list
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node ans = new Node(-1);
        Node curr = ans;
        int pos = 1;
        while (temp != null) {
            if (pos % 2 != 0) {   // odd index
                curr.next = new Node(temp.data);
                curr = curr.next;
            }
            temp = temp.next;
            pos++;
        }
        temp = head;
        pos = 1;
        while (temp != null) {
            if (pos % 2 == 0) {   // even index
                curr.next = new Node(temp.data);
                curr = curr.next;
            }
            temp = temp.next;
            pos++;

        }
        return ans.next;
    }

    static Node OddEvenBrute2(Node head) {

        if (head == null || head.next == null) {
            return head;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        Node temp = head;
        while (temp != null && temp.next != null) {
            arr.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            arr.add(temp.data);
        }

        temp = head.next;
        while (temp != null && temp.next != null) {
            arr.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            arr.add(temp.data);
        }
        int i = 0;
        temp = head;
        while (temp != null) {
            temp.data = arr.get(i);
            i++;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node head = arrayToLL(arr);
        printLL(head);

        head = OddEvenBrute2(head);
        printLL(head);
    }

}
