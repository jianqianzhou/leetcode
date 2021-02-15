class Solution {
   /////使用列竖式的方式进行加法
   public String multiply(String num1, String num2) {
         if("0".equals(num1) || "0".equals(num2)) return "0";   //如果两个数中一个数为0，那么结果返回0
          String ans = "0";
          int n = num1.length();
          int m = num2.length();
          for(int i=n-1; i>=0; i--){
               int carry = 0;
               int a = num1.charAt(i)-'0';
               StringBuilder sb = new StringBuilder("");
                for (int j = n - 1; j > i; j--) {   //从第二个加数开始末尾添加0，第二个添加一个0，第三个添加两个0
                     System.out.println(a);
                     sb.append("0");
               } 
               for(int j=m-1; j>=0; j--){
                   int b = num2.charAt(j)-'0';
                   int temp = a*b+carry;
                   carry = temp/10;
                   temp = temp%10;
                   sb.append(temp+"");
               }
               if(carry>=1) sb.append(carry+"");
               ans = addString(ans, sb.reverse().toString());   //做字符串的加法
          }
          return ans;
    }
    public String addString(String num1,String num2){
        // System.out.println(num1+"\t"+num2);
         int carry = 0;
         StringBuilder sb = new StringBuilder("");
         int i=num1.length()-1,j=num2.length()-1;
         while(i>=0 || j>=0){
             int a = i>=0?num1.charAt(i)-'0':0;
             int b = j>=0?num2.charAt(j)-'0':0;
             int temp = a+b+carry;
             carry = temp/10;
             temp = temp%10;
             sb.append(temp+"");
             i--;j--;
         }
         if(carry>=1) sb.append(carry);
         return sb.reverse().toString();
    }

   /////优化版本，使用数组来求结果
    public String multiply(String num1, String num2){
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[m+n];
        for(int i=n-1; i>=0; i--){
           int a = num1.charAt(i)-'0';
           for(int j=m-1; j>=0; j--){
              int b = num2.charAt(j)-'0';
              res[i+j+1] = a*b+res[i+j+1];   //将结果相加
           }
        }
        int carry = 0;
        for(int i=m+n-1; i>=0; i--){
            int temp  = res[i]+carry;   //因为数组里面都是存放大于10的数，对数组进行处理
            res[i] = temp%10;
            carry = temp/10;
        }
        StringBuilder sb = new StringBuilder("");
        int start = 0;   //第一位有可能为0，需要去除
        if(res[0]==0){
           while(res[start]==0){
               start++;
           }
        }
        for(int i=start; i<m+n; i++){
            sb.append(res[i]);
        }
        return sb.toString();
   }
}
