class Solution {
   public int maxProfit(int[] prices) {
         int n = prices.length;
         int dp[] = new int[n];
         dp[0] = 0;
         int profit = dp[0];
         int min = Integer.MAX_VALUE;  //记录股票的历史最低价
         for(int i=1; i<n; i++){
            min = Math.min(min, prices[i-1]);
            if(prices[i]>min){
                dp[i] = prices[i]-min;
                profit = Math.max(profit, dp[i]);
            }
         }
         return profit;
    }
}
