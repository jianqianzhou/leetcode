class Solution { 
    public int numTrees(int n) {   
         int[] dp = new int[n+1];
         dp[0] = 1;   //节点为0的情况下可以组成的树为1
         dp[1] = 1;   //节点为1的情况下可以组成的树为1
         for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
               dp[i] += dp[i-j]*dp[j-1];
            }
         }
         return dp[n];
    }
}
