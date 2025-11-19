import java.util.LinkedList;
import java.util.Queue;

public class PreOrderTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void preorderUsingQueue(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();   
            System.out.print(curr.data + " ");
             
            if (curr.right != null) q.add(curr.right);
            if (curr.left != null) q.add(curr.left);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Preorder Traversal (using Queue):");
        preorderUsingQueue(root);
    }
}
