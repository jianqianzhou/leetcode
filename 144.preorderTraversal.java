class Solution {
    ///////////////////////////前序遍历 根左右  非递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         if(root==null) return res;
         Stack<TreeNode> queue = new Stack<>();
         TreeNode cur = root;
         while(cur!= null || !queue.isEmpty()){
               while(cur!=null){
                   res.add(cur.val);
                   queue.push(cur);
                   cur = cur.left;
               }

               cur = queue.pop();          
               cur = cur.right;
         }
         return res;
    }

    /////////////////////////前序遍历 递归实现
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root){
           if(root==null) return res;
           res.add(root.val);
           preorderTraversal(root.left);
           preorderTraversal(root.right);
           return res;
    }
}
