class Solution {
     public String addBinary(String a, String b) {
         int n = a.length();
         int m = b.length();
         int i=n-1,j=m-1;
         int carry = 0;
         StringBuilder sb = new StringBuilder();
         while(i>=0 || j>=0 || carry>0){
             int x = i>=0?a.charAt(i)-'0':0;
             int y = j>=0?b.charAt(j)-'0':0;
             int temp = x+y+carry;
             sb.append(temp%2+"");
             carry = temp/2;
             i--;j--;
         }
         return sb.reverse().toString();
    }

   //////////////优化，采用位运算
   public String addBinary(String a, String b) {
            
   }
}
