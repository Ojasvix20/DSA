
import java.util.HashSet;

public class FindIntersectionPoint {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node FindIntersectionOfYBRUTE(Node head1, Node head2) {
        HashSet<Node> s = new HashSet<>();
        Node temp1 = head1;
        while (temp1 != null) {
            s.add(temp1);
            temp1 = temp1.next;
        }

        Node temp2 = head2;
        while (temp2 != null) {
            if (s.contains(temp2)) {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }

    static Node FindIntersectionOfY2Pointers(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1!=temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            if (temp1 == temp2) {
                return temp2;
            }

            if (temp1 == null) {
                temp1 = head2;
            }
            if (temp2 == null) {
                temp2 = head1;
            }
        }

        return temp1;
    }

}
