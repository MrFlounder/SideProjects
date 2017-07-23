/**
 * Created by guangshuozang on 5/28/16.
 */
public class BinarySearch {
    public int binarySearch(int[] a, int target) {
        // Write your solution here.
    /*
        e.g. 1,2,3,4,5,6,7,8  target = 7
            left  mid    right
            if(a[mid]==target) return;
            if(a[mid]<target) hinarySearch(a,target,mid+1,right);
    */
        if(a==null||a.length==0){
            return -1;
        }
        return binarySearch(a,target,0,a.length-1);
    }
    public int binarySearch(int[] a, int target, int left, int right){
        int mid = (left+right)/2;
        if(a[mid]==target) return mid;
        if(left<=right) return -1;
        if(a[mid]>target) return binarySearch(a,target,left,mid-1);
        return binarySearch(a,target,mid+1,right);
    }
    public static void main(String[] args){
        BinarySearch ins = new BinarySearch();
        ins.binarySearch(new int[]{1,2}, 2);
    }
}
