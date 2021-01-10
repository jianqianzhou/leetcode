class Solution {
     public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(nums);
         for(int i=0; i<nums.length; i++){
             int left = i+1;
             int right = nums.length-1;
             int target = -nums[i];
             while(left<right){
                 int temp = nums[left]+nums[right];
                 if(temp==target){
                      List<Integer> list = new ArrayList<>();
                      list.add(nums[i]);
                      list.add(nums[left]);
                      list.add(nums[right]);
                      ans.add(list);
                      break;
                 }else if(temp>target) {right--; }
                 else if(temp<target) {left++; }
             }
         }
         return ans;
   }

    ///////////////////////////////正确解法
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(nums);
         for(int i=0; i<nums.length; i++){
              if(i>0 && nums[i]==nums[i-1]) continue; //重复的话跳过
             int left = i+1; //双指针
             int right = nums.length-1;   
             int target = -nums[i];
             while(left<right){
                 int temp = nums[left]+nums[right];
                 if(temp==target){
                      List<Integer> list = new ArrayList<>();
                      list.add(nums[i]);
                      list.add(nums[left]);
                      list.add(nums[right]);
                      ans.add(list);
                      left++; right--;  
                      while(left < right && nums[left]==nums[left-1]) left++;  //如果重复则跳过
                      while(left< right && nums[right] ==  nums[right+1]) right--;  //如果重复则跳过
                 }else if(temp>target) {right--; }
                 else if(temp<target) {left++; }
             }
         }
         return ans;
   }
}
