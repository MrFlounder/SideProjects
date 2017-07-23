package Class2;

/**
 * Created by guangshuozang on 6/3/16.
 * 1. find --> index, not find --> -1
 * 2. dictionary int[] A unkown size and A is not null
 * 3. when out of bound hit null
 *
 * e.g. A {1,2,4,6,9,X,X,X...} input = 2, return 1
 *
 * == between two reference types is always reference comparison
 More often than not, e.g. with Integer and String, you'd want to use equals instead
 == between a reference type and a numeric primitive type is always numeric comparison
 The reference type will be subjected to unboxing conversion
 Unboxing null always throws NullPointerException
 */
public class SearchInUnknownSizedSortedArray {
//    public int search(Dictionary a, int target){
//        // 1. find the bound
//        int left = 0, right = 1;
//        while(a.get(right) != null && a.get(right) < target){
//            left = right + 1;
//            right = right*2;
//        }
//        // 2. now we do binary search in range left - right
//        while(a.get(left) != null && left <= right){
//            int mid = left + (right - left)/2;
//            // Can I use == here????? .equals return value???
//            if(a.get(mid) == null || a.get(mid) > target){
//                right = mid - 1;
//            }else if(a.get(mid) < target){
//                left = mid + 1;
//            }else{
//                return mid;
//            }
//        }
//        return -1;
//    }
}
/*
*
*
*
* */
