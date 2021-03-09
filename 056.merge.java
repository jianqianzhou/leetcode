class Solution {//list和二维数组之前的转换操作
    public int[][] merge(int[][] intervals) {
          Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); //第一列排序
          List<int[]> lists = new ArrayList<>();
          int m = intervals.length;
          lists.add(new int[]{intervals[0][0],intervals[0][1]});  //将第一个元素加入到lists集合中
          if(m==1 || m==0) return intervals;
          for(int i=1; i<m; i++){
              int left = intervals[i][0];
              int right = intervals[i][1];
              int recent_left = lists.get(lists.size()-1)[0];  //取出最后一个元素与当前元素进行比较
              int recent_right = lists.get(lists.size()-1)[1];
              if(left<=recent_right){  //当当前元素左边坐标小于最近的右边元素时，表示有区间交集
                   right = Math.max(right,recent_right);   //右边的坐标取两个坐标之间的最大值
                   lists.remove(lists.size()-1);  //将最近的元素删除
                   lists.add(new int[]{recent_left,right});  //添加最新的元素
              }else{
                   lists.add(new int[]{left,right});  //没有区间交集
              }
          }
          return lists.toArray(new int[0][]); //返回数组
    }
}
