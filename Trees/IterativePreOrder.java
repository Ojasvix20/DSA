import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class IterativePreOrder{
    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        Stack<TreeNode> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            sb.append(curr.val).append(" ");
            if(curr.right!=null) st.push(curr.right);
            if(curr.left!=null) st.push(curr.left);

        } 
        System.out.println(sb);
    }
}