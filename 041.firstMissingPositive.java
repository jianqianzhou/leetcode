class Solution {
   //不能使用排序，因为排序的时间复杂度为o(nlogn)，但是题目要求的时间复杂度为o(n)
   //遍历一次数组把大于等于1的&&小于数组大小的值放到原数组对应位置，然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
   public int firstMissingPositive(int[] nums) {
         for(int i=0; i<nums.length; i++){
              while(nums[i]>0 && nums[i]<nums.length && nums[i]!=nums[nums[i]-1]){
                   int temp = nums[nums[i]-1];
                   nums[nums[i]-1] = nums[i];
                   nums[i] = temp;
              }
              
         }
         for(int i=0; i< nums.length; i++){
                   if(nums[i]!=i+1){
                       return i+1;
                   }
              }
         return nums.length+1;
    }
}
