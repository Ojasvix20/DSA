public class InsertionLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.next = null;
            this.data = data;
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

    static Node InsertAtHead(Node head, int val) {
        Node newNode = new Node(val);

        newNode.next = head;
        head = newNode;
        return head;
    }

    static Node InsertAtTail(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        }
        if (head.next == null) {
            head.next = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
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

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 7 };
        Node head = arrayToLL(arr);

        head = InsertAtHead(head, 10);
        printLL(head);
        head = InsertAtTail(head, 10);
        printLL(head);
    }
}
