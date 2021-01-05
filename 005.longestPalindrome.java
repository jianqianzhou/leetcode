class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        boolean dp [][] = new boolean[n][n];
        int maxLen = 0, begin = 0;
        for(int j=0; j<n; j++){
           for(int i=0; i<=j; i++){
                if(i==j) dp[i][j] = true;
                if(chs[i]!=chs[j]) dp[i][j] = false;
                else{ 
                    if(j-i<3){ dp[i][j] = true; }
                    else dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j] && maxLen < (j-i+1) ){
                   begin = i;
                   maxLen = j-i+1;
                }
           }
        }
        return s.substring(begin,begin+maxLen);
    }
}
