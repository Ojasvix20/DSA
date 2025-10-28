
public class ImplementAtoi {

    static int StringToInt(String s) {
        int i = 0, sign = 1;
        long num = 0; // use long for overflow detection

        // Step 1: Skip leading spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Read digits
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num * 10 + (s.charAt(i) - '0');

            // Step 4: Handle overflow
            if (sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (num * sign);

    }

    public static void main(String[] args) {
        String s = "123 hello";
        System.out.println(StringToInt(s));

        String s2 = "-123 hello";
        System.out.println(StringToInt(s2));

        String s3 = "hello 123";
        System.out.println(StringToInt(s3));

        String s4 = "  -042";
        System.out.println(StringToInt(s4));
    }
}
