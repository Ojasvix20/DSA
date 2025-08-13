public class Clear_last_i_Bits {
    // clear given no. of bits (makeing them 0)

    // eg : 15 (1111) clear last(i=2) bits. Result: 1100

    public static int clear_i_Bits(int n, int i) {
        // int bitMask= n<<i; wrong method lol
        int bitMask = (-1 << i); // Same as ~( (1 << i) - 1 )
        // -1 in binary: 11111111...1111
        // in Java, ~0 (bitwise NOT of 0) is equal to -1.

        return (n & bitMask);
    }

    public static void main(String[] args) {

        System.out.println(clear_i_Bits(15, 2));
        System.out.println(clear_i_Bits(63, 3));

    }
}
