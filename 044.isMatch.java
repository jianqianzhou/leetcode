class Solution {
     public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean [][]dp = new boolean[m+1][n+1]; 
        dp[0][0] = true;
        for(int j=1; j<=n; j++){ 
            if(p.charAt(j-1)=='*')   //如果模式串的一个字符是“*”，那么都可以匹配，结果为true
                dp[0][j] = true;
            else
                break;
        }
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?'){
                     dp[i][j] = dp[i-1][j-1];   //如果两个字符相等，或者模式串为'?'，匹配成功
                }else if(p.charAt(j-1)=='*'){   //如果模式串字符为"*"，那么分为两种情况：一个是利用“*”做模式匹配，一个是不利用“*”做模式匹配
                     dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[m][n]; 
     }
     
}
