class Solution {
      /////////二维数组转一维数组
      public int kthSmallest(int[][] matrix, int k) {
           int n = matrix.length;
           int m = matrix[0].length;
           int[] tmp = new int[n*m];
           for(int i=0; i<n; i++){
               for(int j=0; j<m; j++){
                   tmp[i*m+j] = matrix[i][j];
               }
           }
           Arrays.sort(tmp);
           return tmp[k-1];
    }

   ///////优化，通过率100%，二分查找，这里二分查找不是mid索引值，而是数组中实际值
   class Solution {
     public int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n-1][n-1];
        while(low<high){  //当low==high，第k小的数即被找出，等于high
            int mid = (low+high)/2;
            int count = findCount(matrix,mid,n);  //找到数组中不大于mid的数组个数
            if(count>=k) high = mid;  //如果count大于等于k，那么值存在在左边部分
            else low = mid+1;      //如果小于等于k，那么在右边部分
        }
        return high;
   }

   public int findCount(int[][] matrix, int mid, int row){
       int j = 0;
       int i = row-1;   //初始位置在左下角
       int count = 0;
       while(i>=0 && j<row){
           if(matrix[i][j]<=mid){   //如果当前位置matrix[i][j]<=mid，那么将数量累加到个数中，同时往右移动
               count += i+1;
               j = j+1;
           }else{
               i = i-1;  //否则向上移动，并且不统计个数
           }
       }
       return count;
   }
}
