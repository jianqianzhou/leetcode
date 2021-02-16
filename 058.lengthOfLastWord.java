class Solution {
     /////通过率11% 
     public int lengthOfLastWord(String s) {  
        if("".equals(s) ) return 0;
        String[] strs = s.split(" ");
        if(strs.length==0) return 0;
        String last = strs[strs.length-1];
        return last.length();
    }

    ///////////不使用length函数，通过率100%
     public int lengthOfLastWord(String s){
          if("".equals(s) ) return 0;
          int count = 0;
          s = s.trim();
          for(int i=s.length()-1; i>=0; i--){
               if(s.charAt(i)==' ') break;
               else count++;
          }
          return count;
    }
}
