class Solution {
  public int reverse(int x) {
         boolean flag = (x>0?false:true);
         x = Math.abs(x);
         int res = 0;
         if(x==0) return 0;
         int i=(x+"").length()-1;
         System.out.println(i);
         while(x!=0){
             res += (x%10)*Math.pow(10,i); //不断组合新的值
             i--;
            if(res>=Integer.MAX_VALUE || -res<=Integer.MIN_VALUE) return 0;
             x=x/10;
         }
         return flag?-res:res;
    }

    //官网解法，不需要判断x的正负值，并且不用计算字符串的长度，在加之前就判断之后的加法会不会溢出、而不是加完之后再判断，效率提升
    public int reverse(int x){
        int rev = 0;
        while(x!=0){
            int pop = x%10;
            x = x/10;
            if(rev > Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE%10)) return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev==Integer.MIN_VALUE/10 && pop < Integer.MIN_VALUE%10)) return 0;
            rev = rev*10+pop;
        }
        return rev;
    }
}

