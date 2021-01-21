class Solution {
    public int search(int[] nums, int target) {
         int low = 0, high = nums.length-1;
         if(nums.length==0) return -1;
         while(low<=high){
             int mid = (low+high)/2;
             if(nums[mid]==target) return mid;
             if(nums[0]<nums[mid]){
                   if(nums[0]<target && target<nums[mid]){
                       high = mid-1;
                   }else{ 
                       low = mid+1;
                   }
             }else{
                  if(nums[mid]<target && target<nums[nums.length-1]){
                        low = mid+1;
                  }else{
                       high = mid-1;
                  }
             }
         }
         return -1;
    }

   ////////////////////////////////////通过解法
   class Solution {
   public int search(int[] nums, int target) {
         int low = 0, high = nums.length-1;
         if(nums.length==0) return -1;
         while(low<=high){ 
             int mid = (low+high)/2;
             if(nums[mid]==target) return mid;
             if(nums[0]<=nums[mid]){        //表示前半部分是有序的，需要加等于号，因为不是严格升序的数组，等于也属于升序
                   if(nums[0]<=target && target<nums[mid]){    ///如果target在前半部分中
                       high = mid-1;
                   }else{ 
                       low = mid+1;
                   }  
             }else{   //表示后半部分是有序的
                  if(nums[mid]<target && target<=nums[nums.length-1]){  //如果target在后半部分中
                        low = mid+1;    //那么low=mid+1
                  }else{
                       high = mid-1;
                  }  
             }  
         }
         return -1;
    }
}
}
