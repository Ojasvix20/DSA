
public class SkipAString {

    public static String skipString(String s, String remove) {
        if (s.length() == 0) {
            return "";
        }
        if (s.startsWith(remove)) {
            int a = remove.length();
            return skipString(s.substring(a), remove);
        }

        return s.charAt(0) + skipString(s.substring(1), remove);
    }

    public static void main(String[] args) {
        String s = "applebananamangoorangepinepple";
        String remove = "banana";

        System.out.println(skipString(s, remove));

    }
}
