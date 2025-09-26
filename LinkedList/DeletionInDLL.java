public class DeletionInDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static void printLL(Node head) {
        Node p = head;
        while (p != null) {
            if (p.next != null) {
                System.out.print(p.data + " <-> ");
            } else {
                System.out.println(p.data);
            }
            p = p.next;
        }
    }

    static Node ArrayToLL(int[] arr) {
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

    static Node DeleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    static Node DeleteTail(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            head = null;
            return head;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }

    static Node DeletePos(Node head, int pos) {

        if (pos <= 0 || head == null) {
            return head;
        }
        if (pos == 1) {
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            head.next = null; // optional cleanup
            return newHead;
        }

        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            if (count == pos) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            return head; // unchanged
        }
        Node previous = temp.prev;
        Node front = temp.next;
        if (previous != null) {
            previous.next = front;
        }
        if (front != null) {
            front.prev = previous;
        }

        temp.prev = null;
        temp.next = null;
        return head;
    }

    static Node DeleteNode(Node head, Node n) {
        // given constraint: n will never be head.

        Node previous = n.prev;
        Node nextNode = n.next;

        if (previous != null) {
            previous.next = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = previous;
        }

        // Cleanup
        n.prev = null;
        n.next = null;
        return head;
    }

    public static void main(String[] args) {
        // Node head = BuildLL();
        int[] arr = { 2, 4, 6, 8, 10 };
        Node head = ArrayToLL(arr);
        printLL(head);

        // head = DeleteHead(head);
        // printLL(head);

        // head = DeleteTail(head);
        // printLL(head);

        // head = DeletePos(head, 3);
        // printLL(head);
        head = DeleteNode(head, head.next.next);
        printLL(head);
    }
}
