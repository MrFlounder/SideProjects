package class8;

/**
 * Created by guangshuozang on 7/13/17.
 */
public class Dedup2 {
    public static String deDup(String input) {
        // first adj string, delete
        // startover
        // until reached the end
        char[] a = input.toCharArray();
        char[] ret = helper(a, 0, -1);
        if (ret.length > 1 && ret[ret.length-1] == ret[ret.length-2]) {
            if (ret[0] == ret[1]) {
                return "";
            } else {
                return String.valueOf(ret[0]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ret.length; i++) {
            sb.append(ret[i]);
        }
        return sb.toString();
    }
    private static char[] helper(char[] input, int start, int end) {
        char[] a = new char[input.length - (end - start) - 1];
        int index=0;
        for (int i=0; i<start; i++) {
            a[index++] = input[i];
        }
        for (int i=end+1; i<input.length; i++) {
            a[index++] = input[i];
        }
        // i - start of the dup
        // j,k - current searching point - when j!=k -- j is the end of the dup
        int i=0, j=0, k=1;
        for (; k<a.length;) {
            if (a[j] == a[k]) {
                j++;
                k++;
            } else {
                if (i == j) {
                    i++;
                    j++;
                    k++;
                } else {
                    return helper(a, i, j);
                }
            }
        }
        return a;
    }
}
