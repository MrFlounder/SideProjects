package Class1;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by guangshuozang on 7/1/17.
 */

    import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive

    public class QuickSort {
        public int[] quickSort(int[] array) {
            // Write your solution here
            if (array == null || array.length == 0) return array;
            helper(array, 0, array.length - 1);
            return array;
        }
        private void helper(int[] array, int start, int end) {
            if (start >= end) return;
            int pivatIndex = randomPivat(start, end);
            swap(array, pivatIndex, end);
            int mid = start + (start - end + 1) / 2;
            partition(array, start, end);
            helper(array, start, mid);
            helper(array, mid + 1, end);
        }
        private void swap(int[] array, int i, int j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        private int randomPivat(int start, int end) {
            int randomNum = ThreadLocalRandom.current().nextInt(start, end + 1);
            return randomNum;
        }
        private void partition(int[] array, int start, int end) {
            int i = start, j = end - 1;
            if (i > j) {
                return;
            }
            while (i < j) {
                if (array[i] > array[end]) {
                    swap(array, i , j--);
                } else {
                    i++;
                }
            }
        }
    }




