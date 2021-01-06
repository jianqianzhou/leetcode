class Solution {
    public int lengthOfLongestSubstring(String s) {
           Map<Character,Integer> win = new HashMap<>(); //定义窗口，窗口中的字符串必须是不重复的
           int left = 0, right = 0, res =0;
           while(right<s.length()){
               char ch = s.charAt(right);
               right++;
               win.put(ch, win.getOrDefault(ch,0)+1);
               while(win.get(ch)>1){  //当窗口中的字符串出现重复的话
                   char d = s.charAt(left);
                   left++;    //窗口往左移
                   int temp = win.get(d);
                   temp--;
                   win.put(d,temp);
               }
               res = Math.max(res,right-left); //去窗口的最大值
           }
           return res;
    }
}
