class Solution {
    public int maxArea(int[] height) {
         int n = height.length;
         int left = 0;
         int right = n-1;
         int res = Integer.MIN_VALUE;
         while(left<right){
             int temp = Math.min(height[left],height[right]);
             int area = temp*(right-left);
             if(temp==height[left]) { left++; res = Math.max(res, area);}   //如果是左指针指向的节点小，那么left++
             else { right--; res = Math.max(res, area);}    //如果是右指针指向的节点小，那么right--
         }
         return res;

    }
}
