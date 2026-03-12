//code forces 380c

// Node(int opening, int closing, int valid) {

//     this.opening = opening;
//     this.closing = closing;
//     this.valid = valid;
// }

import java.util.*;

public class ValidBrackets {

    static Node[] seg;
    static char[] arr;

    static class Node {
        int opening, valid, closing;
    }

    public static Node merge(Node left, Node right) {
        Node res = new Node();
        int matched = Math.min(left.opening, right.closing);
        res.valid = left.valid + right.valid + matched;
        res.opening = left.opening + right.opening - matched;
        res.closing = left.closing + right.closing - matched;

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        String s =  sc.next();
        arr=  s.toCharArray();
        int n= s.length();
        int q = sc.nextInt();
        while(q-->0){
            int ql = sc.nextInt();
            int qr = sc.nextInt();
            ql--; qr--;

            query(0,0,n-1,ql,qr);
        }



        sc.close();
    }
    public static Node query(int idx, int l, int r, int ql, int qr){
        
    }
}