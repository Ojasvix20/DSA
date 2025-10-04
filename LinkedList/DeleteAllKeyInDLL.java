
public class DeleteAllKeyInDLL {

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

    static Node DeleteAllOccurrences(Node head, int key) {
        if (head == null) {
            return null;
        }
        while (head != null && head.data == key) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next != null && temp.next.data == key) {
                Node del = temp.next;
                temp.next = del.next;
                if (del.next != null) {
                    del.next.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1, 69, 3, 5, 4, 87, 69, 0, 69};
        Node head = ArrayToLL(arr);
        printLL(head);

        head = DeleteAllOccurrences(head, 69);

        printLL(head);
    }

}
