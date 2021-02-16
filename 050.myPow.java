class Solution {
     //递归的方式 
     public double quick(double x, int n){
        if(n==0) return 1.0;
        double y = quick(x,n/2);
        return n%2==0?y*y:y*y*x;
    }

    public double myPow(double x, int n) {
         return n>0?quick(x,n):1.0/(quick(x,n));  //将负数转化为正数
    }

   ////////迭代的方式
    public double quick(double x, long n){
        if(n==0) return 1.0;
        double res = 1.0;
        while(n>0){
            if(n%2==1){
                res = res*x;
            }
            x *= x;
            n = n/2;
        }
        return res;
    }

    public double myPow(double x, int n) {
        long N = n;                               //如果不设置为long类型的话，输入数据为 2.00000  -2147483648会产生溢出
        return n>0?quick(x,N):1.0/(quick(x,-N));
    }
}
