public class Binary_Operators {

    public static void main(String[] args) {

        // Binary AND( & )
        // 0 & 0 = 0
        // 0 & 1 = 0
        // 1 & 0 = 0
        // 1 & 1 = 1

        System.out.println("AND: " + (5 & 6));

        // Binary OR( | )
        // 0 | 0 = 0
        // 0 | 1 = 1
        // 1 | 0 = 1
        // 1 | 1 = 1

        System.out.println("OR: " + (5 | 6));

        // Binary XOR( ^ )
        // 0 ^ 0 = 0
        // 0 ^ 1 = 1
        // 1 ^ 0 = 1
        // 1 ^ 1 = 0

        System.out.println("XOR: " + (5 ^ 6));

        // Binary One's Complement
        // ~ 0 = 1
        // ~ 1 = 0
        System.out.println("NOT: "+ ~5);    //returns -6 as MSB is 1 after not operation
        System.out.println("NOT: "+ ~0);    //returns -1 as MSB is 1 after not operation
        /* (eg: 5 in 8 bit: 00000101; After NOT OPn: 11111010 --"1" is the MSB
         to get the value from 11111010, we get 2's comp(1's comp +1)
         => 00000101+1 = 00000111 (111 is 6 in decimal. but we get -6 bcz of MSB being 1 in the no op)  */
        //  therfore ~5 => -6
        //  therfore ~0 => -1

    }
}
