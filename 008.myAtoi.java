class Solution {
    public int myAtoi(String s) {
         s = s.trim();
         char[] chs = s.toCharArray();
         if(s.length()==0 || s==null) return 0; //当字符串为“”或者为null时，返回0
         //if( (chs[0]>='a' && chs[0]<='z') || (chs[0]>='A' && chs[0]<='Z')) return 0;
         if( !Character.isDigit(chs[0]) && chs[0]!='-' && chs[0]!='+') return 0; //当开始的字符串不是数字，如果是字母的话排除'+'和'-'，那么返回0
         boolean flag = false;
         int rev = 0;
         if(chs[0]=='-') flag = true; //如果输入的第一个字符为'-'，表示为负数
         int i = Character.isDigit(chs[0])?0:1;  //如果第一个是数字，表示为正数，也就是去掉第一个符号位，从数字位开始
         while(i<chs.length && Character.isDigit(chs[i])){
              int pop = chs[i]-'0';
              if(rev > (Integer.MAX_VALUE-pop)/10){ //在加法之前先判断是否会越界，因为*10和+pop都可能会越界，所有都移动到右边去
                    return flag?Integer.MIN_VALUE:Integer.MAX_VALUE;
              }
              rev = rev*10 + pop;
              i++;
         }
         return flag?-rev:rev; //返回
    }
}
