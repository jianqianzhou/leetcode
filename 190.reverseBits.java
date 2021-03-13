 public class Solution {
    // you need treat n as an unsigned value
    //通过率100%
     public int reverseBits(int n) {
         return Integer.reverse(n);
     }

     ////使用位操作，
     public int reverseBits(int n){
            int res = 0;
            for(int i=0; i<32; i++){
                 res = res<<1;  //res左移一位，先移位再加
                 int last = n&1;   //获取最后一位值
                 res += last;    //加上最后一位的值  
                 n = n>>1;      //n右移一位，     
            }
            return res;
     }
}
