package class5;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by guangshuozang on 6/7/16.
 */
public class KthSmallestInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here.
        // BFS 2
        int M = matrix.length;
        int N = matrix[0].length;
        Queue<Element> minHeap = new PriorityQueue<Element>(M*N, new MyComparator());
        // 1. start state is matrix[0][0]
        // 2. Generation rule: expand i,j -- > i+1, j  i, j+1
        // 3. termination kth element polled
        // 4. no duplicate allowed
        boolean[][] b = new boolean[matrix.length][matrix[0].length];
        Element res = new Element(matrix[0][0],0,0);
        minHeap.offer(res);
        while(k>=0) {
            res = minHeap.poll();
            int i = res.i;
            int j = res.j;
            if (i + 1 < matrix.length && !b[i + 1][j]) {
                minHeap.offer(new Element(matrix[i + 1][j], i + 1, j));
                b[i+1][j] = true;
            }
            if (j + 1 < matrix[0].length && !b[i][j + 1]) {
                minHeap.offer(new Element(matrix[i][j + 1], i, j + 1));
                b[i][j+1] = true;
            }
            k--;
        }
        return res.value;
    }
    static class MyComparator implements Comparator<Element> {
        @Override
        public int compare(Element i1, Element i2){
            if(i1.value == i2.value){
                return 0;
            }
            return i1.value>i2.value?1:-1;
        }
    }
    private class Element{
        int value;
        int i;
        int j;
        public Element(int value, int i, int j){
            this.value = value;
            this.i = i;
            this.j = j;
        }
    }
}
