class Solution {
    //    60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
    public int divide(int dividend, int divisor) {
         if(dividend ==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
 //        if(dividend ==Integer.MIN_VALUE && divisor==1) return Integer.MIN_VALUE;
         boolean flag = ((dividend ^ divisor) < 0); //相异为1>0   相同为0
         long d = Math.abs((long)dividend);
         long t = Math.abs((long)divisor);
         int result = 0;
         while(d>=t){
            //d -= t; 
            //result +=1;    // 这种方法执行效率较低，时间复杂度为O(n)

            long temp = t;
            long c = 1;
            while(d >= (temp<<1)){  //采用二分法的思想，dividend每次减去尽可能多的2^n个divisor，同时result每次加2^n个
                temp = temp<<1;
                c=c<<1;
            }
            d -= temp; 
            result += c;
         }
         return flag?-result:result;
    }
}
 
