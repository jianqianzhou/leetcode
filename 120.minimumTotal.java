class Solution {
    //将三角形看成一个正方形
    //      2
    //    3   4
    //  5   6   7
    //8   9   1   5
    //看成
    //2
    //3 4
    //5 6 7
    //8 9 1 5
    //求第一个节点到最后一排节点的最短距离，然后从中取出最短的路径
    //错误思路：每次取最小值，达到最后一个节点就为最小值 
    public int minimumTotal(List<List<Integer>> triangle) {
         int n = triangle.size();
         int[][] dp = new int[n][n];
         dp[0][0] = triangle.get(0).get(0);
         for(int i=1; i<n; i++){
             dp[i][0] = dp[i-1][0]+triangle.get(i).get(0);    //第一列的值
             for(int j=1; j<i; j++){
                dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);  //中间列的值
             }
             dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);  //对角线的值
         }
         int res = dp[n-1][0];   //从最后一排取出最小值
         for(int i=1; i<n; i++){
             res = Math.min(res, dp[n-1][i]);
         }
         return res;
    }
}
