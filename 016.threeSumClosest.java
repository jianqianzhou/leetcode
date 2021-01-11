class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 10000;
        for(int i=0; i<nums.length; i++){
              int left = i+1, right = nums.length-1; //双指针
              while(left<right){
                  int temp = nums[left]+nums[right]+nums[i];
                  if(temp==target) return temp;  //如果temp==target，那么返回
                  else if(Math.abs(target-temp)<Math.abs(best-target)) best = temp;
                  if(temp>target){ right--;}
                  else{ left++;}
              }
        }
        return best;
    }
}
