import java.util.*;
import java.io.*;

class TreeNode{
    int val;
    TreeNode right, left;

    TreeNode(int val){
        this.val=val;
        // this.left=left;
        // this.right=right;
    }
}
public class BuildTree{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        TreeNode root = build(sc);
        preorder(root);
    }

    public static TreeNode build(Scanner sc){
        int val = sc.nextInt();
        if(val==-1) return null;
        TreeNode root = new TreeNode(val);
        root.left= build(sc);
        root.right= build(sc);
        return root;
    }

    public static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print( root.val+ " ");
        inorder(root.right);
    }
    static void preorder(TreeNode root) {
    if (root == null) return;

    System.out.print(root.val + " "); // root
    preorder(root.left);             // left
    preorder(root.right);            // right
}
}