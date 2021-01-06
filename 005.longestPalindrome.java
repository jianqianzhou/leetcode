class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        boolean dp [][] = new boolean[n][n]; //记录第i到第j个位置是不是回文串
        int maxLen = 0, begin = 0;
        for(int j=0; j<n; j++){
           for(int i=0; i<=j; i++){
                if(i==j) dp[i][j] = true;
                if(chs[i]!=chs[j]) dp[i][j] = false;
                else{ 
                    if(j-i<3){ dp[i][j] = true; } //当两个字符串之间的距离(j-1)-(i+1)+1<2时，即为一个字符串时，不需要判断，直接为回文串
                    else dp[i][j] = dp[i+1][j-1]; //第i,j之间的字符串是不是回文串：chs[i]==chs[j] && dp[i+1][j-1] i+1和j-1之间的字符串是回文
                }
                if(dp[i][j] && maxLen < (j-i+1) ){ //如果i与j之间的字符串为回文，并且距离大于，记录开始位置和最大距离
                   begin = i;
                   maxLen = j-i+1;
                }
           }
        }
        return s.substring(begin,begin+maxLen);
    }
}
