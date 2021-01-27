class Solution {
    /////////////////////////////非递归
    public List<Integer> postorderTraversal(TreeNode root) {
           List<Integer> ans = new ArrayList<Integer>();
           if(root==null) return ans;
           Stack<TreeNode> stack = new Stack<>();
           TreeNode cur = root;
           TreeNode prev = null;
           while(cur!=null || !stack.isEmpty()){
                while(cur!=null){      //左孩子不断先入栈，类似于中序遍历的写法
                    stack.push(cur);
                    cur = cur.left;
                }
                cur = stack.pop();
                if(cur.right==null || cur.right==prev){  //如果没有右孩子，或者右孩子已经被访问了
                      ans.add(cur.val);  //输出当前节点
                      prev = cur;       //更新节点指针
                      cur = null;
                }else{
                    stack.push(cur);    //如果有右孩子，先把当前节点再次压入栈，
                    cur = cur.right;    //访问右节点
                }
           }
           return ans;
    }
 
    ///////////////////////////////递归方式
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
          if(root==null) return ans;
          postorderTraversal(root.left);
          postorderTraversal(root.right);
          ans.add(root.val);
          return ans;
    }
}
