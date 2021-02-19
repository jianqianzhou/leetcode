class Solution {
  /////////////通过率为5%左右，因为每一次比较后都需要将数组移动位置
  public void merge(int[] nums1, int m, int[] nums2, int n) {
         int i=0,j=0;
         int length = m;  //维护nums1数组的长度
         while(i<length && j<n){  //这里主要长度为length，因为插入后，长度不断在变化
             if(nums1[i]>=nums2[j]){  
                for(int k=length; k>0 && k>=i; k--){  //如果需要插入的时候，需要将nums2的值插入到nums1中
                   nums1[k] = nums1[k-1];
                } 
                nums1[i] = nums2[j];
                length++;  //插入一个值，所以长度需要加1
                j++;
             }
             i++;  //不需要移动的话i++
         }
         for(int k=j; k<n; k++){   //将nums2数组添加到nums1数组后即可
             if(i<m+n)
                nums1[i++] = nums2[k];
         }
    }

   //////////////优化代码：先将两个数组合并之后再排序
   public void merge(int[] nums1, int m, int[] nums2, int n) {
          System.arraycopy(nums2,0 nums1, m, n);
          Arrays.sort(nums1); 
   }

   /////////////优化方法，从后往前，通过率100%，不需要移动数组
   public void merge(int[] nums1, int m, int[] nums2, int n) {
         int p = m+n-1;
         int p1 = m-1, p2 = n-1;
         while(p1>=0 && p2>=0){
              if(nums1[p1]<=nums2[p2]){
                  nums1[p] = nums2[p2];
                  p2--;
                  p--;
              }else{
                 nums1[p] = nums1[p1];
                 p--;
                 p1--;
              }
         }
         System.arraycopy(nums2, 0, nums1, 0, p2 + 1);  //Object src, int srcPos, Object dest, int destPos, int length   这里的p2+1需要注意
   }

  //////////////吧arraycopy函数进行修改
  public void merge(int[] nums1, int m, int[] nums2, int n) {
       int p1=m-1,p2=n-1, p=m+n-1;
        while(p2 >= 0){  //需要p2大于0就需要进行复制操作
            if(p1 >= 0 && nums1[p1] > nums2[p2]){
                nums1[p] = nums1[p1];
                p--;
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p--;
                p2--;
            }
        }
   }
}
