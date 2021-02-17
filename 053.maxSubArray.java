class Solution {
    //采用动态规划
    public int maxSubArray(int[] nums) {
          int n = nums.length;
          int dp[] = new int[n];
          dp[0] = nums[0];
          int max = dp[0];
          for(int i=1; i<n; i++){
             dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);  //动态规划表达式
             max = Math.max(dp[i],max);   //记录最大的连续和，注意这里，不是动态规划最后一个值为最大值，而是需要记录最大值
          }
          return max;
    }
}
