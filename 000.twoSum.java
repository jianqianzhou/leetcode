class Solution {
    public int[] twoSum(int[] nums, int target) {
          Arrays.sort(nums);
          int left = 0;
          int right = nums.length-1;
          while(left<right){
              int temp = nums[left]+nums[right];
              if(temp==target) return new int[]{left,right};
              else if(temp>target) right--;
              else if(temp<target) left++;
          }     
          return new int[]{-1,-1};
    }
}
