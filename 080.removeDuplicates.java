class Solution{
 public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int length = n;
        int count = 1;
        for(int i=1; i<length; i++){    //这里注意数组的长度不是n，而是length
            if(nums[i]==nums[i-1]){
                count++;
                if(count>2){
                   for(int j=i; j<n-1; j++){  //当count数量大于2时，将后面的元素往前移动
                       nums[j] = nums[j+1];
                   }
                   i--;   //这里i需要减1，因为移除了一个元素，下标需要同时进行修改
                   length--;
                }
            }else{
                count = 1;
            }  
        }
        return length;
    }
}
