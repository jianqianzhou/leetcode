class Solution {
    public int romanToInt(String s) {
       Map<Character, Integer> map = new HashMap<>();
           map.put('I',1);
           map.put('V',5);
           map.put('X',10);
           map.put('L', 50);
           map.put('C',100);
           map.put('D',500);
           map.put('M',1000);
           int res = 0;
           int i=0;
           int n = s.length();
           while(i<n){
               char ch = s.charAt(i);
               
               if(ch=='I' && i+1<n && s.charAt(i+1)=='V'){ res += 4;i++;}
               else if(ch=='I' && i+1<n && s.charAt(i+1)=='X') {res += 9;i++;}
               else if(ch=='X'  && i+1<n && s.charAt(i+1)=='L'){ res += 40;i++;}
               else if(ch=='X'  && i+1<n && s.charAt(i+1)=='C') {res += 90;i++;}
               else if(ch=='C' && i+1<n && s.charAt(i+1)=='D'){ res += 400;i++;}
               else if(ch=='C' && i+1<n && s.charAt(i+1)=='M' ) {res+= 900;i++;}
               else{
                  if(i<n){
                       ch = s.charAt(i);
                       res += map.get(ch);
                  }
               }
               i++;
          }
          return res;
    }
 
   ///////////////////////////////////////////
   //把一个小值放在大值的左边，就是做减法，否则为加法。小数据集switch case时间复杂度高于map
   public int romanToInt(String s) {
         int sum = 0;
         int a = getValue(s.charAt(0));
         for(int i=1; i<s.length(); i++){
              int b =  getValue(s.charAt(i));
              if(a<b){ sum -= a;}
              else{sum +=a;}
              a = b;
         }
         sum += a;
         return sum;
   }
   public int getValue(char ch){
        switch(ch){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default :return 0;
        }
   }
}
