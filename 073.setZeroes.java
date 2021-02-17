class Solution {
     ////////通过率时间为5.59%
     public void setZeroes(int[][] matrix) {
         int m = matrix.length;
         int n = matrix[0].length;
         for(int i=0; i<m; i++){         
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                      for(int k=0; k<n; k++){
                          if(matrix[i][k]!=0)
                             matrix[i][k] = -Integer.MAX_VALUE;  //如果不等于0的话，将该值设置为特殊值，注意这里不能直接设置为0，因为会影响后续判断
                      }
                      for(int k=0; k<m; k++){
                           if(matrix[k][j]!=0)
                             matrix[k][j] = -Integer.MAX_VALUE;
                      }
                }
            }
         }
         for(int i=0; i<m; i++){         
            for(int j=0; j<n; j++){
                 if(matrix[i][j]==-Integer.MAX_VALUE) matrix[i][j]=0;  //将特殊值设置为0
            }
         }
    }

    ////////////优化
    public void setZeroes(int[][] matrix) {
         int m = matrix.length;
         int n = matrix[0].length;
         List<int[]> lists = new ArrayList<>();  //使用list数据结构，存储值为0的下标值
         for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                 if(matrix[i][j]==0)
                     lists.add(new int[]{i,j});
            }
         }
         for(int i=0; i<lists.size(); i++){
             int[] t = lists.get(i);
             int row = t[0];
             int col = t[1];
             for(int k=0; k<n; k++) matrix[row][k] = 0;
             for(int j=0; j<m; j++) matrix[j][col] = 0;
         }
    }
}
