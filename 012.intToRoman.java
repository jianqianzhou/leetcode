class Solution {
    public String intToRoman(int num){        //使用map实现
           Map<Integer, String> map = new HashMap<>();
           map.put(1,"I");
           map.put(2,"II");
           map.put(3,"III");
           map.put(4,"IV");
           map.put(5,"V");
           map.put(6,"V");
           map.put(9,"IX");
           map.put(10,"X");
           map.put(50,"L");
           map.put(100,"C");
           map.put(500,"D");
           map.put(1000,"M");
           int rev = 1;
           LinkedList<String> res = new LinkedList<>();
           while(num!=0){
               int pop = num%10;
               num = num/10;
               rev = rev*pop;
               if(map.containsKey(pop))
                   res.addFirst(map.get(pop));
               rev = rev*10;
           }
           StringBuilder sb = new StringBuilder("");
           for(int i=0; i<res.size(); i++){
                sb.append(res.get(i));
           }
           return sb.toString();
    }

    public String intToRoman(int num){
           int[] value = {1,4,5,9,10,40,50,90,100,400,500,900,1000}; //值应该从大往小设置
           String[] roman = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
           StringBuilder res = new StringBuilder("");
           for(int i=0; i<value.length; i++){
               while(num>=value[i]){
                  res.append(roman[i]);
                  num = num - value[i];
               }
           }
           return res.toString();
    }

    ////////////////////////////////////////////
    //正确代码
    public String intToRoman(int num){
           int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
           String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
           StringBuilder res = new StringBuilder("");
           for(int i=0; i<value.length; i++){
               while(num>=value[i]){  //贪心算法，每次选最大的值，先减去遇到的小于num的值
                  res.append(roman[i]);
                  num = num - value[i];
               }
           }
           return res.toString();
    }
}
