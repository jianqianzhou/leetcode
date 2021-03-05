class Solution {
   //求以nums[i]结尾的数组最长子序列长度，如[0,1,0,3,2,3]，
   //第一步，首先对于自身来说，自己本身长度为1，所以初始化都为1
   //第二步，如果nums[i]>nums[j]，那么选择最大的元素加1，[0,1,0,3,2,3] [1,1,1,1,1,1] , 1>0 [1,2,1,1,1,1] ... 2>0 2>1, dp[4] = Math.max(dp[j]+1,dp[i]); dp[4] = 3; dp[5]=dp[4]+1
   //第三步 输出
   public int lengthOfLIS(int[] nums) {
          int n = nums.length;
          int[] dp = new int[n];
          Arrays.fill(dp,1);
          int max = 1;
          for(int i=1; i<n; i++){
              for(int j=0; j<i; j++){
                   if(nums[i]>nums[j]){
                       dp[i] = Math.max(dp[j]+1,dp[i]);
                       max = Math.max(max, dp[i]);
                   }
              }
          }
          return max;
    }
}
