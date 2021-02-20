class Solution {
    ///////////////回溯法相当于穷举法
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
          Arrays.sort(nums);
          boolean[] used = new boolean[nums.length];
          LinkedList<Integer> track = new LinkedList<>();
          backtrace(track, nums, used,0);  //按照47题全排列的方式设置是否使用的数组
          return res;
    }

    public void backtrace(LinkedList track, int [] nums, boolean [] used, int start){
           res.add(new LinkedList<>(track));
           for(int i=start; i<nums.length; i++){
                if(used[i]) continue;
                if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;
                track.add(nums[i]);
                used[i] = true;
                backtrace(track, nums, used,i+1);
                used[i] = false;
                track.removeLast();
           }
    }

   ////////////优化代码 
   List<List<Integer>> res = new LinkedList<>();
   public void backtrack(LinkedList<Integer> track,int nums[],int first){
        
        if(track.size() <= nums.length){
             res.add(new LinkedList<>(track));
        }

        for(int i=first; i<nums.length; i++){
             if(i > first && nums[i] == nums[i-1])
                continue;
             track.add(nums[i]);
             backtrack(track,nums,i+1);
             track.removeLast();
        }
   }

   public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
         LinkedList<Integer> track = new LinkedList<>();
         backtrack(track,nums,0);
         return res;
   }
}
