class Solution {
    List<TreeNode> lists = new ArrayList<>();
    public void flatten(TreeNode root) {
          if(root ==null || (root.left==null && root.right==null)) return;
          preorder(root);     //前序遍历将遍历结果保存在list集合中
          TreeNode node = root;
          for(int i=0; i<lists.size(); i++){
               node.right = lists.get(i);
               node = node.right;
               node.left = null;
          }
    }
    public void preorder(TreeNode root){
          if(root==null) return;
          lists.add(root);
          preorder(root.left);
          preorder(root.right);   
    }



  /////////////////////对上面方法的简化，不需要对根节点做提前判断
  public void flatten(TreeNode root) {
      preorder(root);
      for(int i=1; i<lists.size(); i++){
          TreeNode prev = lists.get(i-1);
          TreeNode cur = lists.get(i);
          prev.right = cur;
          prev.left = null;
      }
  }


  ///////////////非递归方式实现
  public void flatten(TreeNode root){
       if(root==null) return;
       Stack<TreeNode> stack = new Stack<>();
       stack.push(root);
       TreeNode prev = null; //定义prev节点
       while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(prev!=null){
              prev.right = cur; //右节点指向当前节点
              prev.left = null; //左节点指向null
            }
            prev = cur;
            if(cur.right!=null) stack.push(cur.right);   ////先加入右节点，因为先进后出，
            if(cur.left!=null) stack.push(cur.left);
       }
  }
}
