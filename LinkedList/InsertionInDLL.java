// Note: only contains 'before node' insertions
public class InsertionInDLL {

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
        Node tailPrev = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tailPrev.next = newNode;
            newNode.prev = tailPrev;
            tailPrev = newNode;
        }
        return head;
    }

    static Node InsertBeforeHead(Node head, int val) {
        Node newHead = new Node(val);

        if (head == null) {
            head = newHead;
            return head;
        }

        newHead.next = head;
        newHead.prev = null;
        head.prev = newHead;
        return newHead;
    }

    static Node InsertBeforeTail(Node head, int val) {
        if (head == null) {
            return head;
        }
        Node newNode = new Node(val);
        if (head.next == null) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            return head;
        }

        Node tailPrev = head;
        while (tailPrev.next.next != null) {
            tailPrev = tailPrev.next;
        }
        Node tail = tailPrev.next;
        tailPrev.next = newNode;
        newNode.next = tail;
        newNode.prev = tailPrev;
        tail.prev = newNode;

        return head;

    }

    static Node InsertBeforePos(Node head, int pos, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            if (pos == 1) {
                return newNode;
            } else {
                return head; // invalid pos > 1 in empty list
            }
        }
        if (pos <= 1) {
            newNode.next = head;
            head.prev = newNode;
            return newNode; // new head
        }

        int i = 1;
        Node temp = head;
        while (i < pos - 1 && temp.next != null) {
            temp = temp.next;
            i++;
        }

        if (temp.next == null) {
            // means pos was out of bounds → insert at end (optional)
            temp.next = newNode;
            newNode.prev = temp;
            return head;
        }
        Node NodeAtPos = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = NodeAtPos;
        NodeAtPos.prev = newNode;

        return head;
    }

    static Node InsertBeforeNode(Node head, int val, Node n) {
        Node newNode = new Node(val);
        if (n == null) {
            return head;
        }

        if (n == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return head;
        }

        Node nPrev = n.prev;
        n.prev = newNode;
        newNode.next = n;
        nPrev.next = newNode;
        newNode.prev = nPrev;

        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        Node head = ArrayToLL(arr);
        printLL(head);

        // head = InsertBeforeHead(head, 69);
        // printLL(head);
        // head = InsertBeforeTail(head, 69);
        // printLL(head);
        // head = InsertBeforePos(head, 3, 69);
        // printLL(head);
        Node n = head.next.next.next;
        head = InsertBeforeNode(head, 69, n);
        printLL(head);
    }
}
