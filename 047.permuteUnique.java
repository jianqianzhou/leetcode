class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
         Arrays.sort(nums);   //排序，将相同元素的数据放在一起
         LinkedList track = new LinkedList<>();
         boolean used[] = new boolean[nums.length];
         backtrack(nums, track, used);
         return res;
    }
    public void backtrack(int[] nums, LinkedList track, boolean[] used){
         if(track.size()==nums.length){
              res.add(new LinkedList<>(track));
              return;
         }
         for(int i=0; i<nums.length; i++){  //比如输入数据为[1,1,2]
            if(used[i]) continue;   //保证一个数字不能重复被选
            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false) continue;  //保证不能产生重复的排列，如果不加入这句的话会输出[[1,1,2],[1,2,1],[1,1,2],[1,2,1],[2,1,1],[2,1,1]]，used[i-1]==false表示前一个相等的元素已经回溯了，所以continue,不需要再将这个元素加入，直接continue，进入下一次循环即可，否则因为两个值是相同的，就会产生重复的排列
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            used[i] = false;
            track.removeLast();
         }
    }
}
