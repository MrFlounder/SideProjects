package class9;

/**
 * Created by guangshuozang on 7/19/17.
 */
public class ReverseWords {
    public static String reverseWords(String input) {
        // Write your solution here.
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] a = input.toCharArray();
        int i = 0, j = a.length - 1;
        // reverse all
        while (i < j) {
            swap(a, i++, j--);
        }
        i = 0;
        j = 0;
        System.out.println(a);
        while (j < a.length) {
            if (a[j++] != ' ') {
                continue;
            }
            int l = i, r = j - 2;
            // reverse single word
            while (l < r) {
                swap(a, l++, r--);
            }
            i = j;
            System.out.println(a);
        }
        int l = i, r = j - 1;
        // reverse single word
        while (l < r) {
            swap(a, l++, r--);
        }
        return String.valueOf(a);
    }
    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
