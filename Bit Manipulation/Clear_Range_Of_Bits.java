public class Clear_Range_Of_Bits {

    /*
     * clear range of bits ie, set all bit from i to j to '0' we know in binary no.
     * 11110 here 0 is the 0th bit
     * so for ex: 100111010011, i=2, j=7: 1001'1'1010'0'11
     * after clearing bits we get: 100100000011
     * in order to do this we need 2 bitmasks and or them
     * a=111100000000
     * b=000000000011
     * (a|b) & num will give the result
     * a=(~0)<<(j+1) to shift 111111111.... into ...111100000000
     * for b:
     * note that: binary 01= 1 in decimal = 2^1 -1
     * note that: binary 011= 3 in decimal = 2^2 -1
     * note that: binary 0111= 7 in decimal = 2^3 -1
     * note that: binary 01111= 15 in decimal = 2^4 -1
     * note that: binary 011111= 31 in decimal = 2^5 -1
     * we observe that no. of 1s in binary repr. is = power of 2
     * since we need 0 till i-1 pos our no. will be 2^(i)-1 or (1<<i)-1
     * bitmask = a|b
     */

    public static int clearRangeOfBits(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (1 << i) - 1;
        int bitmask = a|b;
        return n&bitmask;
    }

    public static void main(String[] args) {

    }
}
