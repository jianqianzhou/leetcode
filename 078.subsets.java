class Solution {
   List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
         LinkedList<Integer> track = new LinkedList<>();
         backtrack(track, nums,0);
         return res;
    }
    public void backtrack(LinkedList track, int[] nums, int start){
         res.add(new LinkedList<>(track));
         for(int i=start; i<nums.length; i++){
             track.add(nums[i]);
             backtrack(track, nums, i+1);
             track.removeLast();
         }
    }
}
