
public class Add2Numbers {

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
        System.out.println();
    }

    static Node Add(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node temp1 = head1;
        Node temp2 = head2;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int sum = carry;
            if (temp1 != null) {
                sum += temp1.data;
            }
            if (temp2 != null) {
                sum += temp2.data;

            }
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            curr.next=newNode;
            curr=curr.next;

            if(temp1!=null){
                temp1=temp1.next;
            }
            if(temp2!=null){
                temp2=temp2.next;
            }
        }
        if (carry!=0) {
            Node newNode = new Node(carry);
            curr.next=newNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6};
        int[] arr2 = {3, 8, 7};
        Node List1 = arrayToLL(arr1);
        Node List2 = arrayToLL(arr2);
        printLL(List1);
        printLL(List2);

        Node head = Add(List1, List2);
        printLL(head);
    }
}
