package class8;

/**
 * Created by guangshuozang on 7/13/17.
 */
public class RemoveAdjacentDupOne {
    public static String deDup(String input) {
        if (input == null && input.length() == 0) {
            return input;
        }
        System.out.println("input.length: " + input.length());
        char[] a = input.toCharArray();
        int i = 0, j = 0, k = 1;
        while (k < a.length) {
            if (a[j] == a[k]) {
                j++;
                k++;
            } else {
                    if (i == 0) {
                        i++;
                    }
                    a[i] = a[k];
                    j++;
                    k++;
                    i++;


            }

        }
        if (i==0) {
            i = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int n=0; n<i; n++) {
            sb.append(a[n]);
        }
        // Write your solution here.
        return sb.toString();
    }
}
