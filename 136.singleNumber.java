class Solution {
    public int singleNumber(int[] nums) {
         int t = nums[0];
         for(int i=1; i<nums.length; i++){
             t =  nums[i] ^ t;   //异或，相同为0，不相同为1，
         }
         return t;
    }
}
