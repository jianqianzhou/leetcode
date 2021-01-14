class Solution {
    public int searchInsert(int[] nums, int target) {
         int l = 0;
         int r = nums.length-1;
         int ans = 0;
         while(l<r){
             int mid = (l+r)/2;
             if(nums[mid]>=target) {
                   ans = mid;
                   r=mid-1;
             }else {
                 l = mid+1;  
             }
         }
         return ans;
    }


 ///////////////////////////官方正确代码  就是找到pos使得 nums[pos-1]<target<=nums[pos]
  public int searchInsert(int[] nums, int target){
       int l = 0, r = nums.length-1;
       int ans = nums.length; //这里ans的初始化设置为nums.length的长度
       while(l<=r){   //这里需要设置l==r
            int mid = (l+r)/2;
            if(nums[mid]>=target){
                ans = mid;
                r = mid-1;
            }else{
                l=mid+1;
            }
       }
       return ans;
  }
}
