class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            LinkedList<Integer> track = new LinkedList<>();
            backtrace(track, candidates, 0, 0, target);
            return res;
    }
    public void backtrace(LinkedList<Integer> track,int[] nums,int start, int curSum, int target){
         
         if(curSum==target){
             res.add(new LinkedList(track));
             return;
         }
         for(int i=start; i<nums.length; i++){
                int nextSum = curSum + nums[i];
                if(nextSum>target) break;
                track.add(nums[i]);
                backtrace(track, nums, i, curSum+nums[i] ,target);
                track.removeLast();
         }
    }
}
