public class Update_ith_Bit {

    static int ClearBit(int n, int i) {
        int bitmask = 1 << i;
        return (n & (~bitmask));
    }

    public static int SetBit(int n, int i) {
        int bitmask = 1 << i;

        return (n | bitmask);
    }

    public static int updateBit(int n, int i, int newBit) {
        // if (newBit == 0) {
        // return ClearBit(n, i);
        // } else {
        // return SetBit(n, i);
        // }

        // another way (similiar time complexity)

        n = ClearBit(n, i);
        int bitmask = newBit << i;
        return n | bitmask;
    }

    public static void main(String[] args) {
        System.out.println(updateBit(7, 1, 0));

        // 7 (111) becomes (101)=5

    }
}
