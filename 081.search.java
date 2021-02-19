class Solution {
   public boolean search(int[] nums, int target) {
       int n = nums.length;
       int low = 0, high = n-1;
       while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]==nums[low]){  //[1,0,1,1,1]   在这种情况下，nums[mid]==nums[low]，需要将指针往后移动，直到两者不相等，这部分是与33题不相同的地方
               low++;
               continue;
            }
            if(nums[low]<nums[mid]){     //左边是有序的，注意不能写成nums[low]<=nums[mid]需要严格
               if(nums[low]<=target && target<nums[mid]) high = mid-1;    //target在左边部分
               else low = mid+1;
            }else     //右边是有序的，
                if(nums[mid]<target && target<=nums[n-1]) low = mid+1;      //target出现在右边部分
                else high = mid-1;

       }
       return false;
   }
}
