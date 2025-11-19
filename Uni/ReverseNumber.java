class ReverseNumber {
    public static int reverseNumber(int n) {
        int rev = 0;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit; // ✅ correct order
            n /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        // Solution sol = new Solution();
        System.out.println(reverseNumber(410400)); // Output: 321
    }
}
