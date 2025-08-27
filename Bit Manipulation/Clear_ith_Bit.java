public class Clear_ith_Bit {
    static int ClearBit(int n, int i) {
        int bitmask = 1 << i;
        return (n & (~bitmask));
    }

    public static void main(String args[]) {
        System.out.println(ClearBit(31, 3));
    }
}
