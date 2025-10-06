
class RemoveNthFromLast {

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node RemoveFromLastBrute(Node head, int n) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count == n) {
            Node newHead = head.next;
            return newHead;
        }
        int res = count - n;
        temp = head;
        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    static Node RemoveFromLast2Pointers(Node head, int n) {
        Node fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
