
import java.util.*;

class StartOfLoop {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node StartingPoint(Node head) {  // not so effecient as O(n) sc
        Set<Node> set = new HashSet<>();

        Node temp = head;
        set.add(temp);
        while (temp != null) {
            if (set.contains(temp.next)) {
                return temp.next;
            } else {
                set.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }

    static Node StartingPoint2Pointers(Node head) {  // effecient as O(1) sc
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
