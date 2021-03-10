public class Solution {
   public int hammingWeight(int n) {
        int count = 0;
        while(n!=0){
            n = n&(n-1);   //n&(n-1)的作用是消除数字n的二进制表示中的最后一个1
        }
            count++;
        }
         return count;
    }
}
