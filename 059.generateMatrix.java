class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int length = n*n, k=1;
        int up=0,down=n-1,l=0,r=n-1;
        while(true){
            for(int j=l; j<=r; j++){
                res[up][j] = k++;
            }
            if(++up>down) break;

            for(int j=up; j<=down; j++){
                res[j][r]= k++;
            }
            if(--r<l) break;
            for(int j=r; j>=l; j--){
                  res[down][j] = k++;
            }
            if(--down<up) break;
            for(int j=down; j>=up; j--){
                  res[j][l] = k++;
            }
            if(++l>r) break;
        }
        return res;
    }
   
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while(num <= tar){
            for(int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for(int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for(int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for(int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }

}
