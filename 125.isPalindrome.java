class Solution {
    public boolean isPalindrome(String s) {
         int left = 0, right = s.length()-1;
         s = s.toLowerCase();
         while(left<=right){
             char ch = s.charAt(left);
             char ch1 = s.charAt(right);
             if(!Character.isLetter(ch) && !Character.isDigit(ch)){
                  left++;
                  continue;
             }
             if(!Character.isLetter(ch1) && !Character.isDigit(ch1)){
                   right--;
                   continue;
             }
             if(ch!=ch1){
                 return false;
             }else{
                 left++; right--;
             }
         }
         return true;
    }
}
