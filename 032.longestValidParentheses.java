class Solution {
    //使用栈来存储下标值
     public int longestValidParentheses(String s) {
         if("".equals(s)) return 0;
         Stack<Integer> stack = new Stack<>();
         stack.push(-1);
         int res = 0;
         for(int i=0; i<s.length(); i++){
             char ch = s.charAt(i);
             if(ch=='('){stack.push(i);}   //遇到左括号，将其压入栈中
             else{
                stack.pop();   //遇到右括号，不管是否匹配，先pop
                if(!stack.isEmpty()){
                    res = Math.max(res,i-stack.peek());  //将当前右括号下标值减去栈顶元素的值
                }else{
                   stack.push(i);  //如果栈为空，那么将右括号的下标值压入栈中，如")()()"
                }
             }
         }
         return res;
    }
}
