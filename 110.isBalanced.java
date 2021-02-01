class Solution {
     /////从顶向下递归
     public boolean isBalanced(TreeNode root) {
         if(root==null) return true;
         int leftHeight = 0;
         int rightHeight = 0;
         if(root.left!=null)
               leftHeight = helper(root.left);
         if(root.right!=null)
                rightHeight = helper(root.right);
         if(Math.abs(rightHeight-leftHeight)>1) return false;  //求两边节点的高度差，如果高度差大于1，则是不平衡的树
         return isBalanced(root.left) && isBalanced(root.right);  //这里刚开始的时候没有判断子树，直接只写了上面这一行，导致子树是不平衡的情况下没有判断出来。如[1,2,2,3,null,null,3,4,null,null,4]
    }

    public int helper(TreeNode node){
          if(node==null) return 0;
          int left = helper(node.left)+1;
          int right = helper(node.right)+1;
          return Math.max(left,right);
    }

    ///////////////////////简介写法
    private int height(TreeNode node){
       if(node==null){
         return 0;
       }else{
          return Math.max(height(node.left), height(node.right))+1;
       }
    }
   public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int h_l = height(root.left);
        int h_r = height(root.right);
        return Math.abs(h_r-h_l)<=1 && isBalanced(root.left) && isBalanced(root.right);
  }


  //////////////////////////从下往上递归
   public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
