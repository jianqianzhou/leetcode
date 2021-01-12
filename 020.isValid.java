class Solution { 
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack();
         int i=0;
         while(i<s.length()){
              char ch = s.charAt(i); 
              if(ch=='(' || ch=='{' || ch=='[') {stack.push(ch);}
              else{
                   if(stack.isEmpty()) return false;   
                   else if(ch==')'){ 
                       if(!stack.isEmpty() && stack.pop()!='(') return false;
                   }
                   else if(ch=='}'){ 
                      if(!stack.isEmpty() && stack.pop()!='{') return false;
                   }
                   else if(ch==']'){ 
                      if(!stack.isEmpty() && stack.pop()!='[') return false;
                   }
              }
              i++;
         }
         if(stack.isEmpty()) return true;
         else return false;
    }

   ////////////////////////////////官网解法
   public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        if(n%2==1) return false;  //如果是奇数直接返回false；
        Map<Character,Character> map = new HashMap<>(){{
             put('(',')');
             put('{','}');
             put('[',']');
        }};
        char[] chs = s.toCharArray();
        for(int i=0; i<chs.length; i++){
             if(map.containsKey(chs[i])){ 
                 stack.push(chs[i]);
             }else{
                  if(!stack.isEmpty()){
                     if(chs[i]!=map.get(stack.pop()))
                          return false;
                  }else{
                     return false;
                  }
             }
        }
        if(stack.isEmpty()) return true;
         else return false;
   }
}
