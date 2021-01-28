class Solution {
    public boolean isSymmetric(TreeNode root) {
          return isSameTree(root,root);   
    }

     public boolean isSameTree(TreeNode p, TreeNode q) {
           if(p==null && q==null) return true;
           if(p==null && q!=null) return false;
           if(p!=null && q==null) return false;
           if(p.val != q.val ) return false;
           return isSameTree(p.left,q.right) && isSameTree(p.right,q.left);  //与前者判断相同的树有所差别，不是isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 对称判断
    }
}
