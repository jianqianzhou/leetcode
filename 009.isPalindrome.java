class Solution {
  public boolean isPalindrome(int x) {
         String s = x+"";
         int start = 0, end = s.length()-1;
         while(start < end){ 
              if(s.charAt(start)!=s.charAt(end)) return false;
              start++;
              end--;
         }
         return true;
    }

   /////////////官网解法/////////////////////
   public boolean isPalindrome(int x){
        if(x<0 || (x%10==0 && x!=0) ) return false; //x是负数， x最后一位为0并且x!=0 那么不是回文
        int rev = 0;
        while(x>rev){
           int pop = x%10;
           x = x/10;
           rev = rev*10 + pop;
        }
        return rev==x || rev/10==x; //对于偶数rev==x； 对于奇数12  123  则将最后一位去掉
   }
}
