class Solution {
public int numDistinct(String s, String t) {
           int m = s.length();
           int n = t.length();
           int[][] dp = new int[n+1][m+1];   //定义dp数组
           for(int i=1; i<=n; i++){   //第0列全部的值是0，表示s串为“”的情况下，模式串都匹配
               dp[i][0] = 0;
           }
           for(int j=0; j<=m; j++){
                dp[0][j] = 1;      //第0行的值全部为1，表示模式串为""的情况下，都能匹配上，值都初始化为1
           }
           for(int i=1; i<=n; i++){
               for(int j=1; j<=m; j++){
                   if(t.charAt(i-1)==s.charAt(j-1)){   //如果两个值相等
                       dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
                       System.out.println(dp[i][j]);
                    }else{
                        dp[i][j]=dp[i][j-1];
                    }
               }
           }
           return dp[n][m];
    }
}

