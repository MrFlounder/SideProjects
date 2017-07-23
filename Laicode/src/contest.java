import class9.ReverseWords;

/**
 * Created by guangshuozang on 7/22/17.
 */
public class contest {
    public static int findLongestChain(int[][] pairs) {
        /*
            c, d c < d
            a, b a < b
            if b < c -- a, b - c, d

            Test cases:
            1. 1 2 | 2 3 | 3 4
            2. 1
        */
        Sort(pairs);
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        if (pairs.length == 1) {
            return 1;
        }
        int[] longest = new int[pairs.length];
        int result = 1;
        int row = 0, col = 0;
        while (row < pairs.length) {
            longest[row] = 1;
            for (int j = 0; j < row; j++) {
                if (pairs[j][col+1] < pairs[row][col]) {
                    longest[row] = Math.max(longest[j] + 1, longest[row]);
                }
            }
            // if (pairs[row-1][col+1] < pairs[row][col]) {
            //     cur = cur++;
            //     row++;
            // } else {
            //     longest = Math.max(longest, cur);
            //     row++;
            // }
            result = Math.max(result, longest[row++]);
        }
        return result;
    }
    private static void Sort(int[][] pairs) {
        for (int i = 0; i < pairs.length; i++) {
            int min = pairs[i][0];
            int minIndex = i;
            for (int j = i; j < pairs.length; j++) {
                if (pairs[j][0] < min) {
                    minIndex = j;
                    min = pairs[j][0];
                }
                swap(pairs, i, minIndex);
            }
            swap(pairs, i, minIndex);
        }
    }
    private static void swap(int[][] a, int i, int j) {
        int temp1 = a[i][0];
        int temp2 = a[i][1];
        a[i][0] = a[j][0];
        a[i][1] = a[j][1];
        a[j][0] = temp1;
        a[j][1] = temp2;
    }

    public static void main(String[] arg) {
        //System.out.println(Parentheses.validParentheses(2));
        //System.out.println(RemoveAdjacentDupOne.deDup(""));

        //System.out.println(Dedup2.deDup("eabcdddcbba"));
        //System.out.println(isSubString.strstr("abbaabbab", "bbab"));
        //System.out.println(RemoveSpace.removeSpaces("I love yahoo")+"|");
        //System.out.println(ReverseWords.reverseWords("It is a good day"));
        //[[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]]
        //   -9 8| -6 9| -6 -2| -5 3| -1 4| 0 3| 1 6| 8 10|
        //    1     1       1      2     1    1   2    3
        System.out.print(contest.findLongestChain(new int[][] {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}}));
    }
}
