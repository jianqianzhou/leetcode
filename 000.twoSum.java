错误解法1：

 
错误解法
class Solution {
    public int[] twoSum(int[] nums, int target) {
          Arrays.sort(nums);
          int left = 0;
          int right = nums.length-1;
          while(left<right){
              int temp = nums[left]+nums[right];
              if(temp==target) return new int[]{left,right};
              else if(temp>target) right--;
              else if(temp<target) left++;
          }     
          return new int[]{-1,-1};
    }
}
 错误原因是：没有考虑到下标的问题，排序后会打乱掉下标

 错误解法2

class Solution {
    public int[] twoSum(int[] nums, int target) {
          Map<Integer,Integer> map = new HashMap<>();
          for(int i=0; i<nums.length; i++){
              map.put(nums[i],i);
          }
          for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i]))
              return new int[]{i,map.get(target-nums[i])};
          }
          return new int[]{-1,-1};
    }
}
错误原因：【3,2,4】target=6，会返回本身的下标【0,0】 

通过代码：

提交通过，时间复杂度为o(n*n)
 
class Solution {
      public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
             for(int j=i+1; j<nums.length; j++){
                  if(nums[i] + nums[j] == target){
                       return new int[]{i,j};
                  }
             }
        }
        return new int[]{-1,-1};
    }
}
时间复杂度比较高 

  public int[] twoSum(int[] nums, int target) {
          Map<Integer,Integer> map = new HashMap<>();
          for(int i=0; i<nums.length; i++){
              map.put(nums[i],i);
          }
          for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
               int j = map.get(target-nums[i]);
                  if(i!=j) return new int[]{i,j};
                }
          }
          return new int[]{-1,-1};
    }
 考虑到下标不能重复问题。

官方解法：

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
一边循环一边将map添加进去， 对于每一个 x，我们首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
