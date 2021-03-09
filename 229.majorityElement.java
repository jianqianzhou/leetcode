class Solution {
   public List<Integer> majorityElement(int[] nums) {
         Map<Integer,Integer> map = new HashMap<>();
         int n = nums.length;
         for(int i=0; i<n; i++){
               map.put(nums[i],map.getOrDefault(nums[i],0)+1);
         }
         List<Integer> res = new ArrayList<>();
         for(Map.Entry<Integer, Integer> entry: map.entrySet()){
             int key = entry.getKey();
             int value = entry.getValue();
             if(value>n/3){
                  res.add(key);
             }
         }
         return res;
    }

    ///////////////////////摩尔投票法
    public List<Integer> majorityElement(int[] nums){
          List<Integer> res = new ArrayList<>();
          int cand1 = nums[0], count1 = 0;
          int cand2 = nums[0], count2 = 0;
          int n = nums.length;
          for(int i=0; i<n; i++){
              if(nums[i]==cand1){
                  count1++;
                  continue;
              }
              if(nums[i]==cand2){
                   count2++;
                   continue;
              }
              if(count1==0){
                 cand1 = nums[i];
                 count1++;
                 continue;
              }
              if(count2==0){
                 cand2 = nums[i];
                 count2++;
                 continue;
              }
              count1--;
              count2--;
          }
          count1=0;count2=0;
          for(int num:nums){
               if(cand1==num) count1++;
               else if(cand2==num) count2++;
          }
          if(count1>n/3) res.add(cand1);
          if(count2>n/3) res.add(cand2);
          return res;
    }
}
