class Solution {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> partition(String s) {
         LinkedList<String> track = new LinkedList<>();
         backtrace(track, s, 0, s.length());
         return res;
    }

    public void backtrace(LinkedList track,String s, int start, int len){
         if(start==len){             //当当前下标值等于len大小时，将元素添加到集合中
             res.add(new LinkedList<>(track));
             return;
         }
         for(int i=start; i<s.length(); i++){
             String temp = s.substring(start,i+1);  //这里，substring的起始索引
             if(!isPalindrome(temp)) continue;
             track.add(temp);
             backtrace(track, s, i+1, len);
             track.removeLast();
         }
    }

    public boolean isPalindrome(String s){
          int left = 0;
          int right = s.length()-1;
          while(left <= right){
             if(s.charAt(left)!=s.charAt(right)){
                 return false;
             }else{
                 left++;
                 right--;
             }
          }
          return true;
    }
}
