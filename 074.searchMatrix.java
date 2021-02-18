class Solution {
    ////////////////错误代码
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int rows = mid/m;
            int cols = mid%m;
            if(matrix[rows][cols]==target) return true;
            else if(matrix[rows][cols]>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }

   ////正确代码
   public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0, high = m*n-1;
        while(low<=high){
            int mid = (low+high)/2;  
            int rows = mid/n;   //行值计算
            int cols = mid%n;   //列值计算
            if(matrix[rows][cols]==target) return true;
            else if(matrix[rows][cols]>target) high=mid-1;
            else low=mid+1;
        }
        return false;
    }
}
