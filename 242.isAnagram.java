class Solution {
      //////////通过率83%，转成数组排序，然后比较两个数组是否相等
      public boolean isAnagram(String s, String t) {
           char[] chs = s.toCharArray();
           char[] chs1 = t.toCharArray();
           Arrays.sort(chs);
           Arrays.sort(chs1);
           if(chs1.length!=chs.length) return false;
           for(int i=0; i<chs.length; i++){
                 if(chs[i]!=chs1[i]) return false;
           }
           return true;
    }

    ////通过率21%
    public boolean isAnagram(String s, String t){
          if(s.length()!=t.length()) return false;
          Map<Character,Integer> map = new HashMap<>();
          for(int i=0; i<s.length(); i++){
              char ch = s.charAt(i);
              map.put(ch, map.getOrDefault(ch,0)+1);
          }
          for(int i=0; i<t.length(); i++){
               char ch = t.charAt(i);
               map.put(ch, map.getOrDefault(ch,0)-1);
               if(map.get(ch)<0) return false;
          }
          return true;
    }
}
