import java.util.Scanner;

public class check_odd_even_using_bit {

    public static void main(String[] args) {

        /*
         * we use the logic that for all even nos. LSB is always '0'
         * and for all odd nos. LSB is always '1'
         * we use AND operator for this
         */
        // eg: 3 : 011 (and it with 1: 001)

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. to check: ");
        int x = sc.nextInt();
        int bitmask = 1;

        if ((x & bitmask) == 1) {
            System.out.println("odd");
        } else {
            System.out.println("even");
        }

        sc.close();

    }
}
