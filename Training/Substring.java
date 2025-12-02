
public class Substring {

    // p-processed string, up- unprocessed string.
    private static void subseq(String p, String up) {
        if (up.length() == 0) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq(p, up.substring(1));
        subseq(p + ch, up.substring(1));
    }

    public static void main(String[] args) {
        subseq("", "abc");
    }
}
