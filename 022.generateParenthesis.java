class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
           backtrace(n,n,"");
           return res;
    }

    public void backtrace(int left, int right, String out){
         if(left==0 && right==0){
            res.add(out);
            return;
         }
         if(right>left )
             backtrace(left, right-1, out+")"); //当剩余的右括号大于左括号时，如out="("，左括号为2，右括号为3，那么添加右括号
         if(left>0)  //左括号大于0添加左括号
            backtrace(left-1, right, out+"(");
    }
}
