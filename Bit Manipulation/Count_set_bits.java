public class Count_set_bits {
    public static int count_set(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) { // check LSB
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(count_set(7));

    }
}
