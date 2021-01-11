class Solution {
    List<String> res = new LinkedList<>();
     Map<Character,String> map = new HashMap<>(){{
                put('2',"abc");
                put('3',"def");
                put('4',"ghi");
                put('5',"jkl");
                put('6',"mno");
                put('7',"pqrs");
                put('8',"tuv");
                put('9',"wxyz");
            }};
    public List<String> letterCombinations(String digits) {
          if(digits.length()>0){
               trace(digits, 0);
          }
          return  res;
    }
    StringBuilder sb = new StringBuilder();
    public void  trace(String digits, int index){
         if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
         }
         String letters = map.get(digits.charAt(index));
         for(int i=0; i<letters.length(); i++){
               sb.append(letters.charAt(i));
               trace(digits,index+1);
               sb.deleteCharAt(sb.length()-1);  //删除最后一个元素
         }   
    }
}
