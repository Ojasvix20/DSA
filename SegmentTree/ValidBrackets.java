//code forces 380c
class Node{
   char data;
   int opening, valid,closing; 
   Node(char data, int opening, int closing,int valid){
    this.data= data;
    this.opening=opening;
    this.closing= closing;
    this.valid=valid;
   }
}
public class ValidBrackets{

    public static Node merge(Node left, Node right){
        Node res = new Node();
        int matched = Math.min(a.opening, b.closing);
        res.valid = a.valid+ b.valid + MATCHED;
        res.opening = a.opening + b.opening  - matched;
        res.closing = a.closing + b.closing  - matched;

        return res;
    }

    public static void main(String[] args){

    }
}