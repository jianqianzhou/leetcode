class Solution {
    /////////////////////////超过的时间为20%多，
    public int[] searchRange(int[] nums, int target) {
          int n = nums.length;
          int l = 0, r = n-1;
          while(l<=r){
              int mid = (l+r)/2;
              if(nums[mid]==target){
                  int t = mid; int h = mid;
                  while(t>=0 && nums[t]==target){t--;} 
                  while(h<=n-1 && nums[h]==target){ h++;}
                  return new int[]{t+1,h-1};
              }else if(nums[mid]>target){
                  r--;
              }else{
                  l++;
              }
              
          }
          return new int[]{-1,-1};
    }

    public int[] searchRange(int[] nums, int target){
         int leftidx = binarySearch(nums, target, true);   //找到数组中第一个等于target的位置（第一个大于等于target的下标）
         int rightidx = binarySearch(nums, target, false)-1;  //找到数组中第一个大于target的位置减一（第一个大于target的下标）
         if(leftidx <= rightidx && rightidx < nums.length && nums[leftidx]==target && nums[rightidx]==target){    //查看条件是否符合
               return new int[]{leftidx, rightidx};
         }
         return new int[]{-1,-1};
    }
    public int binarySearch(int[] nums, int target, boolean lower){
          int l = 0, r = nums.length-1;
          int ans = 0;
          while(l<=r){
               int mid = (l+r)/2;
               if(nums[mid]>target || (lower && nums[mid]>=target)){
                     ans = mid; 
                     r = mid-1;
               }else{
                    l = mid+1;
               }
          }
          return ans;
    }
}
