class Solution {
     //正方形矩阵旋转90度
     //   1 2 3
     //   4 5 6
     //   7 8 9 
     //  先对角线矩阵旋转
     //  1 4 7
     //  2 5 8
     //  3 6 9
     //  然后左右两列旋转
     //  7 4 1
     //  8 5 2
     //  9 6 3
     //  即可，旋转90度
     public void rotate(int[][] matrix) {
         int n = matrix.length;
         for(int i=0; i<n; i++){
             for(int j=0; j<i; j++){
                  int temp = matrix[i][j];
                  matrix[i][j] = matrix[j][i];
                  matrix[j][i] = temp;
             }
         }

         for(int i=0; i<n; i++){
             for(int j=0; j<n/2; j++){
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[i][n-j-1];
                 matrix[i][n-j-1] = temp;
             }
         }
    }
}
