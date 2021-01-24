class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
             Arrays.sort(candidates);
             LinkedList<Integer> track = new LinkedList<>();
             backtrace(track, candidates, 0, 0, target);
             return res;
    }
    public void backtrace(LinkedList<Integer> track, int[] nums, int start, int curSum, int target){
        if(curSum == target){
              res.add(new LinkedList(track));
        }
        for(int i=start; i<nums.length; i++){
               int nextSum = nums[i]+curSum;
               if(nextSum>target) break;
               if(i>start && nums[i]==nums[i-1]) continue;     //解集中不包括重复的组合
               track.add(nums[i]);
               backtrace(track, nums, i+1, nextSum, target);
               track.removeLast();
        }
    }
}
