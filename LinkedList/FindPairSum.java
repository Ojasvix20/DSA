
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairSum {

    // FIND ALL PAIRS WITH GIVEN SUM IN SORTED DLL
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

    static List<List<Integer>> FindPairs(Node head, int sum) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        if (head == null || head.next == null) {
            return listOfLists;
        }
        Node left = head;
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }
        while (left != right && left.prev != right) {

            int currSum = left.data + right.data;
            if (currSum > sum) {
                right = right.prev;
            } else if (currSum < sum) {
                left = left.next;
            } else {
                listOfLists.add(Arrays.asList(left.data, right.data));
                left = left.next;
                right = right.prev;
            }
        }
        return listOfLists;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 9};
        Node head = ArrayToLL(arr);
        printLL(head);

    }

}
