class Solution {
    public int lengthOfLongestSubstring(String s) {
           Map<Character,Integer> win = new HashMap<>();
           int left = 0, right = 0, res =0;
           while(right<s.length()){
               char ch = s.charAt(right);
               right++;
               win.put(ch, win.getOrDefault(ch,0)+1);
               while(win.get(ch)>1){
                   char d = s.charAt(left);
                   left++;
                   int temp = win.get(d);
                   temp--;
                   win.put(d,temp);
               }
               res = Math.max(res,right-left);
           }
           return res;
    }
}
