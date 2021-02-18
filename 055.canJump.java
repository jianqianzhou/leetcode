class Solution {
    //////////贪心策略
   public boolean canJump(int[] nums) {          
           int n = nums.length;
           int rightmost = 0;
           for(int i=0; i<n; i++){
                if(rightmost>=i){   //如[0,2,3] rightmost=0, i=1, 这样就进入不了判断，返回false
                     rightmost = Math.max(nums[i]+i,rightmost);
                     if(rightmost>=n-1){
                          return true;
                     }
                       
                 }
           }
           return false;
    }
}
