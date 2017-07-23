package Class2;

/**
 * Created by guangshuozang on 6/3/16.
 * int[N][M]
 *
 * e.g.
 *      1 2 3
 *      4 5 6  y   position x, y --> array[y*M + x]   range i,j  mid = i+(j-1)/2, y = mid/M, x = mid%M
 *      7 8 9
 *        x
 */
public class SearchInSortedMatrix1 {
    public int[] search(int[][] matrix, int target){
        if(matrix.length == 0 || matrix[0].length == 0) return new int[]{-1,-1};
        int N = matrix.length;
        int M = matrix[0].length;
        int i = 0;
        int j = M * N - 1;
        return binarySearch(matrix, target, i, j, M);

    }
    public int[] binarySearch(int[][] matrix, int target, int left, int right, int M){
        while(left <= right){
            int mid = left + (right - left)/2;
            int x = mid % M;
            int y = mid / M;
            if(matrix[y][x] == target){
                return new int[]{x,y};
            }else if(matrix[x][y] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}
