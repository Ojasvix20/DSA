public class Binary_shift {
    
    public static void main(String[] args) {
        
        // Binary Left Shift (<<)
        // 5<<2 --> shift 5 two bits to the left
        // 5= 000101 ---> 010100 (=20) (to fill the empty space in right we set 0)
        // general formula: a<<b = a * (2^b)  (^ : power not xor)
        System.out.println("Left Shift: "+(5<<2));
        
        
        // Binary Right Shift (>>)
        // 5>>2 --> shift 5 two bits to the right
        // 5= 000101 ---> 000001 (=1) (to fill the empty space in left we set 0)
        // general formula: a<<b = a / (2^b)  (^ : power not xor)
        System.out.println("Right Shift: "+(5>>2));
        System.out.println("Right Shift: "+(6>>1));
    }
}
