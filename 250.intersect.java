class Solution {
      ////////////通过率35%，将数组1使用map来存放,key-value为<出现的元素，元素出现的次数>，然后循环第二个数组，判断该值是否存在map中
      public int[] intersect(int[] nums1, int[] nums2) {
         List<Integer> list = new ArrayList<>();
         int n = nums1.length; int m = nums2.length;
         Map<Integer,Integer> map = new HashMap<>();
         for(int i=0; i<n; i++){
              map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
         }
         for(int i=0; i<m; i++){
            if(map.containsKey(nums2[i])){
                 int value = map.get(nums2[i]);  //如果存在map中，表示是交集，但是需要将当前元素在map集合中的出现次数减一
                 if(value==1) map.remove(nums2[i]); //如果仅仅出现一次，那么直接删除该key值
                 else map.put(nums2[i],value-1);
                 list.add(nums2[i]);
            }
         }
         int[] res = new int[list.size()];   
         for(int i=0; i<list.size(); i++){
              res[i] = list.get(i);
         }
         return res;
    }

    /////////////优化，为了降低空间复杂度，先遍历较短的数组并存放在哈希表中，然后在遍历较长的数组得到交集，时间通过率22%
    public int[] intersect(int []nums1, int[] nums2){
         if(nums1.length > nums2.length)
            return intersect(nums2, nums1);   //总能保证第一个数组长度是最小的
         int n = nums1.length; int m = nums2.length;
         Map<Integer,Integer> map = new HashMap<>();
         for(int i=0; i<n; i++){
              map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
         }
         int[] res = new int[nums2.length];
         int index = 0;
         for(int i=0; i<m; i++){
              int count = map.getOrDefault(nums2[i],0);
              if(count>0){
                  res[index++] = nums2[i]; 
                  count--;
                  if(count==0) map.remove(nums2[i]);
                  else map.put(nums2[i],count);
              }
         }
         return Arrays.copyOfRange(res,0,index);
    }
 
    ////排序和双指针，通过率100%, 初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。
    //如果nums2是存储在磁盘上，磁盘内存有限，并且不能一次加载所有元素到内存，所以无法高效对nums2进行排序，因此推荐使用map的方式，因为每次读取nums2中的一部分数据，做并行处理即可.
    public int[] intersect(int[] nums1, int[] nums2){
         Arrays.sort(nums1);
         Arrays.sort(nums2);
         int n = nums1.length; int m = nums2.length;
         int res[] = new int[Math.min(n,m)];
         int p1 = 0, p2 =0, index = 0;
         while(p1<n && p2<m){
            if(nums1[p1]>nums2[p2]) p2++;  
            else if(nums1[p1]<nums2[p2]) p1++;
            else{res[index++] = nums1[p1]; p1++; p2++;}
         }   
         return Arrays.copyOfRange(res,0,index);
    }
}
