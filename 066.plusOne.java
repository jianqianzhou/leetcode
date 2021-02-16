class Solution {
   public int[] plusOne(int[] digits) {
        int n = digits.length-1;
        int temp = digits[n]+1;
        digits[n] = temp%10;
        int carry = temp/10;
        if(carry==0) return digits;
        else{
          for(int i=n-1; i>=0; i--){
             temp = digits[i]+carry;
             digits[i] = temp%10;
             carry = temp/10;
          }
          if(carry>=1){
              int[] newd = new int[n+2];
              newd[0] = carry;
              for(int i=0; i<=n; i++){
                  newd[i+1] = digits[i];
              
              }
              return newd;
          }
          return digits;
        }
    }

   //////首先去掉数组赋值
   public int[] plusOne(int[] digits) {
      int n = digits.length-1;
      int temp = digits[n]+1;
      digits[n] = temp%10;
      int carry = temp/10;
      for(int i=n-1; i>=0; i--){
           temp = digits[i]+carry;
           digits[i] = temp%10;
           carry = temp/10;
      }
      if(carry>=1){
           digits = new int[n+2];   //可以使用这种方式直接添加数组的大小
           digits[0] = carry;
      }
        return digits;
      }

   ///////////////优化代码
   public int[] plusOne(int[] digits) {
       int len = digits.length;
       for(int i=len-1; i>=0; i--){   //将最后一位相加也放在循环中实现
          digits[i]++;
          digits[i] = digits[i]%10;
          if(digits[i]!=0) return digits;  //不存在进位的情况直接返回
       } 
       digits = new int[len+1];   //表示存在进位的情况
       digits[0] = 1; 
       return digits;
   }
}
