class Solution {
  public void nextPermutation(int[] nums) {
          int n = nums.length;
          int i = n-1;
          for(i=n-1; i>0; i--){    
               if(nums[i-1]<nums[i]){   //（1）从数组的末端开始查询，找到第一个下降的元素的位置，如：3 4 5 2 1，第一个下降的元素是4，元素索引是1
                    break;
               }
          }
          int k = i-1; 
          if(k==-1){  //如果没有找到，说明原数组就是最大的排列了，那么反转输出最小的那个排列即可
               reverse(nums, 0, n-1);
               return;
          }
          int j = n-1;      //（2）从[k+1,n-1]区间中找到大于nums[k]的最小值，因为这个区间是降序排列的，找到的元素为5，索引值为2
          while(j>=k){
               if(nums[k]<nums[j]){ //所以从后往前找，当遇到大于nums[k]的值就就可以终止while循环了
                    break;
               }
               j--;
          }             
          swap(nums,j,k); //（3）交换这两个元素的值，变成：3 5 4 2 1
          reverse(nums,k+1,n-1); //(4) 将[k+1,n-1]区间内的元素逆序反转，变成3 5 1 2 4

    }
    //用来交换数组i和j位置的值
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //用来反转数组l和r之间的元素
    public void reverse(int[] nums, int l, int r){
       while(l<r){
             swap(nums,l,r);
             l++; r--;
       }
    }
}
