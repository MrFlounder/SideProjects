package class5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by guangshuozang on 6/7/16.
 */
public class Ksmallest {

        public int[] kSmallest(int[] array, int k) {
            // Write your solution here
            //1. sort 2. min heap 3. max heap 4.  quick sort
            // use max heap here
            if(array==null||array.length==0) return array;
            if(k==0){
                return new int[0];
            }
            Queue<Integer> maxHeap = new PriorityQueue<Integer>(k, new ReverseComparator());
            for(int i=0;i<k;i++){
                maxHeap.offer(array[i]);
            }
            for(int i=k;i<array.length;i++){
                if(maxHeap.peek()>array[i]){
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
            return toArray(maxHeap);
        }
        private int[] toArray(Queue<Integer> q){
            int length = q.size();
            int[] result = new int[length];
            for(int i=length-1;i>=0;i--){
                result[i] = q.poll();
            }
            return result;
        }
        private static class ReverseComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer i1, Integer i2){
                if(i1.equals(i2)){
                    return 0;
                }
                return i1>i2?-1:1;
            }
        }

        public static void main(String[] args){
            Ksmallest ins = new Ksmallest();
            System.out.println(Arrays.toString(ins.kSmallest(new int[]{5, 5, 8, 1, 2}, 4)));
        }


}
