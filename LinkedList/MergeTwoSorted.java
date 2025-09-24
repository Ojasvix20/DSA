public class MergeTwoSorted {
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

    static Node MergerFn(Node head1, Node head2) {
        Node h1=head1;
        Node h2=head2;
        return head1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 1, 2, 3, 4 };
        int[] arr2 = { 1, 3, 4, 2 };

        Node head1 = arrayToLL(arr1);
        Node head2 = arrayToLL(arr2);
    }
}
