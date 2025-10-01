
import java.util.Stack;

class CheckPalindrome {

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
        System.out.println();
    }

    public static Node reverseList(Node head) {
        Node prev = null;   // previous node
        Node curr = head;   // current node
        Node next = null;   // store next node

        while (curr != null) {
            next = curr.next;   // save next
            curr.next = prev;   // reverse link
            prev = curr;        // move prev forward
            curr = next;        // move curr forward
        }

        return prev;  // new head
    }

    static boolean CheckPalindromeUsingStack(Node head) {
        //NOT EFFICIENT AS O(n) space complexity

        Stack<Integer> s = new Stack<>();
        Node temp = head;
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.data != s.pop()) {
                return false;
            } else {
                temp = temp.next;
            }
        }
        return true;
    }

    static boolean CheckPalindromeUsing2Pointers(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverseList(slow.next);

        Node head2 = newHead;
        Node head1 = head;
        while (head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        reverseList(newHead);
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 2, 1};
        Node head = arrayToLL(arr);
        printLL(head);
        // System.out.println(CheckPalindromeUsingStack(head));
        System.out.println(CheckPalindromeUsing2Pointers(head));
    }
}
