
public class RemoveDuplicatesDLL {

    // Remove supicates from a sorted DLL
    static class Node {

        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node ArrayToDLL(int[] arr) {

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

    static void PrintDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next != null) {
                System.out.print(temp.data + " <-> ");
            } else {
                System.out.println(temp.data);
            }
            temp = temp.next;
        }
    }

    static Node DeleteDuplicates(Node head) {
        // TC: O(n) SC: O(1)
        if (head == null) {
            return null;
        }

        Node temp = head;

        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;;
            if (temp.data == nextNode.data) {
                while (nextNode != null && temp.data == nextNode.data) {
                    nextNode = nextNode.next;
                }
                temp.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 2, 2, 3, 4, 5, 8,};

        Node head = ArrayToDLL(arr);
        PrintDLL(head);
        head = DeleteDuplicates(head);
        PrintDLL(head);
    }

}
