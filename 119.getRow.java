class Solution {
    public List<Integer> getRow(int rowIndex) {
          List<List<Integer>> ret = new ArrayList<>();
          int n = rowIndex+1;
          for(int i=0; i<n; i++){
             List<Integer> row = new ArrayList<>();
             for(int j=0; j<=i; j++){
                 if(j==0 || i==j) row.add(1);
                 else row.add(ret.get(i-1).get(j-1)+ret.get(i-1).get(j));
             }
             ret.add(row);
          }
          return ret.get(rowIndex);
    }
}

   /////////////////优化的方式
class Solution {
    private int[][] C=new int[50][50];
    private int C(int n,int m){   //不断递归
        if(n==m||n==0)return C[n][m]=1;
        if(C[n][m]!=0)return C[n][m];
        return C[n][m]=C(n,m-1)+C(n-1,m-1);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer>ans=new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++)ans.add(C(i,rowIndex));
        return ans;
    }
}
