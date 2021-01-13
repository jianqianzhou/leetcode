class Solution {
    public int strStr(String haystack, String needle) {
             int L = needle.length();
             int n = haystack.length();
             if(L==0) return 0;
             for(int start=0; start<n-L+1; start++){
                   if(haystack.substring(start,start+L).equals(needle)){
                           return start;
                   }
             }
             return -1;
    }

    ////////////////////////////////////////不使用substring函数
    public int strStr(String haystack, String needle) {
           int m = haystack.length(); int n = needle.length();
           if(n==0) return 0;
           for(int i=0; i<=m-n; i++){
               for(int j=0; j<n; j++){
                    if(haystack.charAt(i+j)==needle.charAt(j)){
                           if(j==n-1) return i;
                           continue;
                    }
                    else break;
               }
           }
           return -1;
    }
}
