package class8;

/**
 * Created by guangshuozang on 7/15/17.
 */
public class isSubString {
    public static int strstr(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        if (small.length() == 0) {
            return 0;
        }
        long patternHash = hash(small);
        for (int i = 0; i < large.length() - small.length() + 1; i++) {
            String tar = large.substring(i, i + small.length());
            long compareHash = hash(tar);
            if (compareHash == patternHash && equal(tar, small)) {
                return i;
            }
        }
        return -1;
    }
    private static long hash(String tar) {
        return 0;
    }
    private static boolean equal(String s1, String s2) {
        return s1.equals(s2);
    }
}
