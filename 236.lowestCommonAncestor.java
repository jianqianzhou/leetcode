class Solution {
    /////////////迭代，通过率8%
    Map<Integer, TreeNode> path = new HashMap<>(); //使用map来记录节点和其父节点之间的信息，<当前节点，父节点>
    public void getPath(TreeNode root){
          if(root!=null){
              getPath(root.left);
              if(root.left!=null)
                 path.put(root.left.val, root);
              getPath(root.right);
              if(root.right!=null)
                  path.put(root.right.val, root);
          }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          getPath(root);
          Set<TreeNode> set = new HashSet<>();    //记录节点p到根节点的访问记录
          while(p != root){
             set.add(p);
             p = path.get(p.val);
          }
          set.add(root);   //添加根节点，因为根节点可能是祖先节点
          while(!set.contains(q)){  //如果q节点还未达到访问的节点处，则不断向前访问其父节点信息
              q = path.get(q.val);
          }
          return q;  //q节点到达第一个p节点访问的节点处，就是共同的祖先节点
    }

   /////////////递归的方式
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
