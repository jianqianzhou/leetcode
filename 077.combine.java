class Solution {
     List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
         int nums[] = new int[n];
         for(int i=0; i<n; i++){
              nums[i] = i+1;
         }
         LinkedList<Integer> track = new LinkedList<>();
         backtrace(k, nums, track, 0);
         return res;
    }
    public void backtrace(int k, int[] nums, LinkedList track, int start){
        if(track.size()==k){
              res.add(new LinkedList<>(track));
              return;
        }
        for(int i=start; i<nums.length; i++){
             track.add(nums[i]);
             backtrace(k, nums, track, i+1);
             track.removeLast();
        }
    }
}
