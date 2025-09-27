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
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            temp.next = newNode;
            newNode.prev = temp;
            temp = newNode;
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

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        Node head = ArrayToLL(arr);
        printLL(head);

        head = InsertBeforeHead(head, 69);
        printLL(head);
    }
}
