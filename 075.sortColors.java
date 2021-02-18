class Solution {
     ///////////////其实可以使用排序的思路，但是时间复杂度高，通过率为10%
    public void sortColors(int[] nums) {
         int n = nums.length;
         for(int i=0; i<n; i++){
             for(int j=i+1; j<n; j++){
                 if(nums[j]<nums[i]){
                      int temp = nums[j];
                      nums[j] = nums[i];
                      nums[i] = temp;
                 }
             }
         }
    }

    //////优化代码，双指针法，
    public void sortColors(int[] nums){
        int n = nums.length;
        int left = 0, right = n-1;
        int cur = 0;   //这里要注意多使用一个指针，指向当前遍历的值
        while(cur<=right){
             if(nums[cur]==0){  //如果遇到的值为0，那么将值交换到最前面
                 int temp = nums[cur];
                 nums[cur] = nums[left];
                 nums[left] = temp;
                 left++;
                 cur++;       //这里注意当交换的值为0时，需要将当前指针加1
             }else if(nums[cur]==2){  //如果遇到的值为2，交换到最后，但是cur不加，因为可能交换过来的值为0
                 int temp = nums[cur];
                 nums[cur] = nums[right];
                 nums[right] = temp;
                 right--;
             }else   //如果遇到的值为1，那么cur加1，什么操作都不需要做
                cur++;
       }
    }
}
