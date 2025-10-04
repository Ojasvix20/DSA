
public class Sort012 {

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

    static Node SortBrute(Node head) {
        Node temp = head;
        int count0 = 0, count1 = 0, count2 = 0;

        while (temp != null) {
            if (temp.data == 0) {
                count0++;
            } else if (temp.data == 1) {
                count1++;
            } else if (temp.data == 2) {
                count2++;
            }
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (count0 != 0) {
                temp.data = 0;
                count0--;
            } else if (count1 != 0) {
                temp.data = 1;
                count1--;
            } else if (count2 != 0) {
                temp.data = 2;
                count2--;
            }
            temp = temp.next;
        }

        return head;
    }

    static Node SortEfficient(Node head) {
        Node dummy0 = new Node(-1);
        Node curr0 = dummy0;
        Node dummy1 = new Node(-1);
        Node curr1 = dummy1;
        Node dummy2 = new Node(-1);
        Node curr2 = dummy2;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                curr0.next = temp;
                curr0 = curr0.next;
            } else if (temp.data == 1) {
                curr1.next = temp;
                curr1 = curr1.next;
            } else if (temp.data == 2) {
                curr2.next = temp;
                curr2 = curr2.next;
            }
            temp = temp.next;
        }

        curr0.next = (dummy1.next != null) ? dummy1.next : dummy2.next;
        curr1.next = (dummy2.next != null) ? dummy2.next : null;
        curr2.next = null;

        return dummy0.next;
    }

    public static void main(String[] args) {
        int arr[] = {0, 2, 1, 2, 0, 1, 0, 2, 0};
        Node head = arrayToLL(arr);
        printLL(head);

        // head = SortBrute(head);
        // printLL(head);
        head = SortEfficient(head);
        printLL(head);
    }

}
