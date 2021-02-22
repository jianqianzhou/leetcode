class Solution {
    public int mySqrt(int x) {
        if(x==0) return 0;
        int low = 1; int high = x/2, ans = 1; 
        while(low<=high){
           int mid = (low+high)/2;
           if((long)mid*mid<=x){   //这里需要使用long类型的变量，
               ans = mid;
               low = mid+1;
           } else high = mid-1;
        }
        return ans;
    }
}
