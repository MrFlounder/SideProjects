package class8;

/**
 * Created by guangshuozang on 7/15/17.
 */
public class RemoveSpace {
    public static String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] a = input.toCharArray();
        int slow = 0, fast = 0;
        while (slow < a.length && fast < a.length) {
            while (fast < a.length && a[fast] == ' ') {
                fast++;
            }

            while (fast < a.length && a[fast] != ' ') {
                a[slow++] = a[fast++];
            }
            if (slow < a.length) {
                a[slow++] = ' ';
            }
        }
        if (slow > 0 && a[slow - 1] == ' ') {
            return new String(a, 0, slow - 1);
        }
        return new String(a, 0, slow);
    }
}
