class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

class BinaryTree {

    Node root;

    // INSERT
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    // INORDER (Sorted order in BST)
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.value + " ");
        inorder(node.right);
    }

    // PREORDER
    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // POSTORDER
    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value + " ");
    }

    // SEARCH
    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) return false;

        if (value == node.value) return true;

        if (value < node.value)
            return search(node.left, value);
        else
            return search(node.right, value);
    }
}
public class Tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();   // 20 30 40 50 60 70 80
        tree.preorder();
        tree.postorder();

        System.out.println(tree.search(40)); // true
        System.out.println(tree.search(100)); // false
    }
}