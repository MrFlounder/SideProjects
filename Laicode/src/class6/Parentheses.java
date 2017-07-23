package class6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guangshuozang on 7/9/17.
 */
public class Parentheses {
    public static List<String> validParentheses(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) {
            list.add("");
            return list;
        }
        helper(list, n, n, 0, "");
        // Write your solution here.
        return list;
    }
    private static void helper(List<String> list, int l, int p, int index, String result) {
        System.out.println("Start: current level: " + index + ";" + "result : " + result);
        if (l == 0 && p == 0) {
            list.add(result);
            return;
        }

        if (l > 0) {
            helper(list, l - 1, p, index + 1, result + "(");
        }
        if (l < p) {
            helper(list, l, p - 1, index + 1, result + ")");
        }
        System.out.println("End : current level: " + index + ";" + "result : " + result);
    }

}
