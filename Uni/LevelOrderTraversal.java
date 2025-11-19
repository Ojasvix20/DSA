import java.util.Queue;
import java.util.LinkedList;

public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int height(Node root) {
        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return (1 + Math.max(leftHeight, rightHeight));
    }

    static void printLevelOrder(Node root) {
        if (root == null)
            return;

        System.out.println(height(root));

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node curr = q.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }

            System.out.println();
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

        System.out.println("Level Order Traversal:");
        printLevelOrder(root);
    }
}
