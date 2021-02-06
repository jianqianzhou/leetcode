class Solution {
    /////采用的是数组的方式获取
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        int dp[][] = new int[numRows][numRows];
        for(int i=0; i<numRows; i++){
            dp[i][0] = 1;
        }
        for(int i=1; i<numRows; i++){
             for(int j=1; j<=i; j++){   //注意这里不是j<numRows，采用j<=i可以表示下半角的元素
                if(i==j) dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
             }
        }
        for(int i=0; i<numRows; i++){
            List<Integer> lists = new ArrayList<>();
            for(int j=0; j<=i; j++){
                 
                lists.add(dp[i][j]);
            }
            res.add(lists);
        }
        return res;
    }


    ///////////官方解法，可以不用申请数组，将list的结果当做二维数组来获取值,空间复杂度降低
    public List<List<Integer>> generate(int numRows){
         List<List<Integer>> res = new ArrayList<>();
         for(int i=0; i<numRows; i++){
             List<Integer> row = new ArrayList<>();
             for(int j=0; j<=i; j++){
                  if(j==0 || i==j){
                     row.add(1);
                  }else{  //else记得写
                     row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                 }
             }
             res.add(row);
         }
         return res;
    }
}
