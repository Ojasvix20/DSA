public class Set_ith_bit {

    // to set a bit '1' we will use OR Operation

    public static int SetBit(int n, int i) {
        int bitmask = 1 << i;

        return (n | bitmask);
    }

    public static void main(String[] args) {
        System.out.println(SetBit(3, 5));
    }

    // 3: 000011 becomes: 0100011 == 35

}
