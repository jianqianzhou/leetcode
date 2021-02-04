class Solution {
    /////////////////////非递归////////中序遍历，左根右
    public List<Integer> inorderTraversal(TreeNode root) {
          List<Integer> ans = new ArrayList<>();
          if(root==null) return ans;
          Stack<TreeNode> queue = new Stack<>();  //使用Stack，不能使用LinkedList
          TreeNode cur = root;    
          while(cur != null || !queue.isEmpty()){  //这两个判断条件非常重要，当cur为null时，不能进入循环
               while(cur!=null){
                    queue.push(cur); 
                    cur = cur.left;
               }
               cur = stack.pop();
               ans.add(cur.val);
               cur = cur.right;
          }
          return ans;
    }

    ////////////////////////递归迭代//////////
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root){
          if(root==null) return ans;
          inorderTraversal(root.left);
          ans.add(root.val);
          inorderTraversal(root.right);
          return ans;
    }
}
