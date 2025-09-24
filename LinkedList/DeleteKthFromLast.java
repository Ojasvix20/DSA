
public class DeleteKthFromLast {
    static class Node {

        int data;
        Node next;

        Node(int data) {
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
    }

    static Node DeleteKthLast(Node head, int k) {

        Node dummy = new Node(0); // dummy node before the head
        dummy.next = head;
        Node fast = dummy, slow = dummy;

        // Move fast k+1 steps so slow lands before the node to delete
        for (int i = 0; i <= k; i++) {
            if (fast == null)
                return head; // k > length case -- edge case
            fast = fast.next;
        }

        // Move both until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove slow.next
        slow.next = slow.next.next;

        return dummy.next; // return new head (handles if head was removed)
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Node head = arrayToLL(arr);
        DeleteKthLast(head, 3);
        printLL(head);
    }
}
