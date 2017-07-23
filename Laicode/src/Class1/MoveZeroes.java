package Class1;

import java.util.Arrays;

/**
 * Created by guangshuozang on 6/27/17.
 */
public class MoveZeroes {
    public static int[] moveZero(int[] array) {
            // Write your solution here.
            if (array == null || array.length == 0) {
                return array;
            }
            int i = 0;
            int j = array.length - 1;
            while(i < j) {
                if (array[i] != 0) {
                    i++;
                } else if (array[j] == 0) {
                    j--;
                } else {
                    swap(array, i++ , j--);
                }
            }
            return array;
        }
    protected static void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
    }
    public static void main(String[] arg) {
        System.out.println(Arrays.toString(moveZero(new int[]{1, 1, 0, 0, 1, 1})));
    }

}
