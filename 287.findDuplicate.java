class Solution {
    public int findDuplicate(int[] nums) {   //该方法改变了数组的结构，所以不行，但是能过，通过率为55%
        Arrays.sort(nums);
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }    
        return nums[nums.length-1];
    }
    
   /////////////二分查找
   public int findDuplicate(int[] nums){
         int left = 0, right = nums.length-1;
         while(left < right){
               int mid = (left+right)/2;   //int mid = (left+right)>>1, 当left+right溢出时候，无符号右移保证结果依然是正确的
               int count = 0;
               for(int num : nums){
                    if(num<=mid){ count++; }
               }
               if(count>mid) right=mid;   //小于等于mid的个数如果严格大于4个，此时重复元素一定位于[1,4]之间
               else left = mid+1;
         }
         return left;
    }
 
    //////快慢指针，通过率100%
    public int findDuplicate(int[] nums){  
           int slow = 0, fast = 0;
           slow = nums[slow];
           fast = nums[nums[fast]];
           while(slow!=fast){
               slow = nums[slow];
               fast = nums[nums[fast]];
           }
           slow = 0;
           while(fast!=slow){
               slow = nums[slow];
               fast = nums[fast];
           }
           return slow;
    }
}
