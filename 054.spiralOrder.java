class Solution {
     public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int up = 0, down=m-1,left=0,right=n-1;
        while(true){
            for(int j=left; j<=right; j++){
               res.add(matrix[up][j]);
            }
            if(++up>down) break;
            for(int i=up; i<=down; i++){
               res.add(matrix[i][right]);
            }
            if(--right<left) break;
            for(int j=right; j>=left; j--){
                res.add(matrix[down][j]);
            }
            if(--down<up) break;
            for(int i=down; i>=up; i-- ){
                res.add(matrix[i][left]);
            }
            if(++left>right) break;
        }
        return res;
    }

}
