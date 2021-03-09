class Solution {
    ///通过率5%
    public int rob(int[] nums) {
      int n = nums.length;
      if(n==0 || nums==null) return 0;
      if(n==1) return nums[0];
      //拆分成两个数组来判断，取两个数组之间的最大值
      //                           可以偷第一家，但不能偷最后一家，   可以偷最后一家，但不能偷第一家
      return Math.max(myRob(Arrays.copyOfRange(nums,0,n-1)),myRob(Arrays.copyOfRange(nums,1,n)));   ///copyOfRange(origin, int from, int to):original被要复制的数组，from要复制的初始索引（包括的），to最终索引（不包括）
    }

    public int myRob(int[] nums){
         int dp[] = new int[nums.length];
         if(nums.length==0) return 0;
         if(nums.length==1) return nums[0];
         dp[0] = nums[0];
         dp[1] = Math.max(dp[0], nums[1]);
         for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
         }
         return dp[nums.length-1];
    }
}
