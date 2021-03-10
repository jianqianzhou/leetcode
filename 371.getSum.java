class Solution {
    public int getSum(int a, int b) {
          while(b!=0){
              int temp = a^b;  //相加的值，不算进位
              b = a&b<<1;  //b为进位
              a = temp;  //a为相加后的值
          }
          return a;  
    }
}
