class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         Arrays.sort(nums);  //需要先排序
         List<List<Integer>> res = new ArrayList<>();
         for(int i=0; i<nums.length; i++){
             if(i>0 && nums[i]==nums[i-1]) continue;
             for(int j=i+1; j<nums.length; j++){
                 if(j>i+1 && nums[j]==nums[j-1]) continue;
                 int left = j+1, right = nums.length-1;
                 int target1 = target-(nums[i]+nums[j]);
                 int temp = nums[left]+nums[right];
                 while(left<right){
                   if(temp==target1){
                      List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                      res.add(list);
                      left++; right--;
                      while(left < right && nums[left]==nums[left-1]) left++;      //left-1容易错
                      while(left < right && nums[right]==nums[right+1]) right--;  //right+1
                   }else if(temp<target1){left++;}
                    else{right--;}
                 }
                 
             }
         }
         return res;
    }
}
