
class SortLL {

    static class Node {

        int data;
        Node next;

        public Node(int data) {
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
        System.out.println();
    }

    static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static Node mergeTwoLists(Node list1, Node list2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next;
    }

    static Node Sort(Node head) {
        // we will be performing merge sort on the LL.
        if (head == null || head.next == null) {
            return head;
        }
        Node middle = findMiddle(head);
        Node leftHead = head, rightHead = middle.next;
        middle.next = null;

        leftHead = Sort(leftHead);
        rightHead = Sort(rightHead);

        return mergeTwoLists(leftHead, rightHead);
    }

    public static void main(String[] args) {
        int[] arr ={1,5,3,6,9,8,5,4,2};
        Node head=arrayToLL(arr);
        printLL(head);
        
        Sort(head);
        printLL(head);

    }
}
