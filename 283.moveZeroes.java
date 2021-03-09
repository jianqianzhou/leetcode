class Solution {
   //////通过率100%，将非零的数据移动到数组最前方，后续补零
  public void moveZeroes(int[] nums){
        int n = nums.length;
        int j = 0;
        for(int i=0; i<n; i++){
           if(nums[i]!=0){
                nums[j++] = nums[i];
           }
        }   
        for(int k=j; k<n; k++){
             nums[k] = 0;
        }         
  }

  //////通过率100%，一边将非零的元素移动到最前方，一边将零移动到数组后方，相对于以上方式不需要
  public void moveZeroes(int[] nums) {
       int j=0;
       for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
       }
  }
}
