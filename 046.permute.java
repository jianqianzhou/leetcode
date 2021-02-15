class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
         LinkedList<Integer> track = new LinkedList<>();
         backtrack(nums, track);
         return res;
    }
    public void backtrack(int[] nums,LinkedList track){
        if(track.size()==nums.length){
            res.add(new LinkedList<>(track));
            return;
        }
        for(int i=0; i<nums.length; i++){
              if(track.contains(nums[i])) continue;    //如果已经存在了，就继续下一次循环
              track.add(nums[i]);
              backtrack(nums, track);
              track.removeLast();
        }
    }
}
