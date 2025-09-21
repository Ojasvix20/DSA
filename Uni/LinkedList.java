import java.util.Scanner;

public class LinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first = sc.nextInt();
        n--;
        Node head = new Node(first);
        Node curr = head;

        while (n > 0) {
            int k = sc.nextInt();
            Node temp = new Node(k);
            curr.next = temp;
            curr = curr.next;
            n--;
        }

        Node p = head;
        while (p != null) {
            if (p.next != null) {
                System.out.print(p.data + " -> ");
            } else {
                System.out.print(p.data);
            }
            p = p.next;
        }
        sc.close();
    }
}
