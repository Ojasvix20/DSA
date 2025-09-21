public class DeletionInLL {

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

    static Node DeleteHead(Node head) {
        if (head == null) {
            return head;
        }
        head = head.next; // java has garbage collector unline C++ so we dont manually have to delete old
                          // head
        return head;
    }

    static Node DeleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        Node tail = temp.next;
        temp.next = null; // delete tail in LL
        return tail;

    }

    static Node DeleteAtPos(Node head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 1) {
            return head.next;
        }
        Node curr = head;
        for (int i = 1; i < k - 1 && curr != null; i++) {
            curr = curr.next;
        }

        // If k is more than the length of the list
        if (curr == null || curr.next == null) {
            return head;
        }
        curr.next = curr.next.next;
        return head;
    }

    static Node DeleteValue(Node head, int val) {
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 7 };
        Node head = arrayToLL(arr);

        // delete head
        // System.out.println(DeleteHead(head).data);
        // delete tail
        // System.out.println("tail removed: " + DeleteTail(head).data);
        // printLL(head);

        // delete At Position
        DeleteAtPos(head, 3);
        printLL(head);
    }
}
