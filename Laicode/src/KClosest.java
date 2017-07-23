import java.util.Arrays;

/**
 * Created by guangshuozang on 5/29/16.
 */
public class KClosest {
        public int[] kClosest(int[] a, int target, int k) {
            // Write your solution here
            if(a==null||a.length==0){
                return a;
            }
            int left = closest(a, target);
            int[] ret = new int[k];
            int right = left + 1;
            for(int i=0;i<k;i++){
                if(right>a.length-1) ret[i] = a[left--];
                else if(left<0) ret[i] = a[right++];
                else{
                    if(Math.abs(a[left] - target)>Math.abs(a[right]-target)) ret[i] = a[right++];
                    else ret[i] = a[left--];
                }
            }
            return ret;
        }
        public int closest(int[] a, int target){
            int left = 0, right = a.length-1;
            while(left<right-1){
                int mid = (left+right)/2;
                if(a[mid] == target){
                    return mid;
                }else if(a[mid] > target){
                    right = mid;
                }else{
                    left = mid;
                }
            }
            if(a[right] - target>target - a[left]) return left;
            else return right;
        }

        public static void main(String[] args){
            KClosest ins = new KClosest();
            System.out.println(Arrays.toString(ins.kClosest(new int[]{},2,2)));
        }

}
