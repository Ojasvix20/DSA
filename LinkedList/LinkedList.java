// includes arrayToLL, search in LL, print LL, get length of LL
class LinkedList {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node arrayToLL(int[] arr) {      //convert array to 1D Linked List
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

    static int lengthOfLL(Node head) {      //fetch the length of the linked list
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    static Boolean SearchInLL(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 7};

        Node head = arrayToLL(arr);

        // Printing LL
        Node p = head;
        while (p != null) {
            if (p.next != null) {
                System.out.print(p.data + "->");
            } else {
                System.out.println(p.data);
            }
            p = p.next;
        }

        // printing LL length:
        System.out.println("Length of Linked List: " + lengthOfLL(head));

        System.out.println(SearchInLL(head, 4));
        System.out.println(SearchInLL(head, 7));
    }
}
