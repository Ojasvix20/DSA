import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DoublyLinkedList {

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

    static Node BuildLL() throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        if (n == 0) {
            sc.close();
            return null;
        }

        // create head
        Node head = new Node(sc.nextInt());
        Node temp = head;
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            temp.next = newNode;
            newNode.prev = temp; // link back   
            temp = newNode;
        }
        sc.close();
        return head;
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

    static void printReverse(Node head){
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        while(tail!=null){
            System.out.print(tail.data+" ");
            tail=tail.prev;
        }
        System.out.println();
    }   

    static Node ArrayToLL(int[] arr){
        Node head= new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode= new Node(arr[i]);
            temp.next=newNode;
            newNode.prev=temp;
            temp=newNode;
        }
        return head;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Node head = BuildLL();
        int[] arr = {2,4,6,8,10};
        Node head = ArrayToLL(arr);
        printLL(head);
        
        printReverse(head);
    }
}
