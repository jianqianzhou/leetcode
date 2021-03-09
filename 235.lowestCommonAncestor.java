class Solution {
    ///////////////递归，通过率90%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root==null) return null;
            while(true){
               if(root.val > p.val && root.val > q.val) root=root.left;       //不断找到左子树
               else if(root.val < p.val && root.val< q.val) root=root.right;  //不断找到右子树
               else{   // root.val > p.val && root.val<q.val     //当满足条件的时候break掉
                     break;
               }
            }
            return root;
    }

    ///////////迭代，通过率32%，输入root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
    //path1等于[6,2],path2等于[6,8]，祖先节点为6
    //p=2, q=4时path1=[6,2] path2=[6,2,4]，祖先节点为2
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
            List<TreeNode> path1 = getPath(root, p);   //记录路径
            List<TreeNode> path2 = getPath(root, q);
            TreeNode ancestor = null;
            for(int i=0; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i)==path2.get(i)){
                     ancestor = path1.get(i);
                }else{
                   break;  //如果找到不相等的值，则前面一个节点为祖先节点
                }
            }
            return ancestor;
    }
    public List<TreeNode> getPath(TreeNode root, TreeNode target){
          List<TreeNode> path = new ArrayList<>();
          path.add(root);
          while(root!=target){
              if(root.val > target.val){
                  root = root.left;
              }else{
                  root = root.right;
              }
              path.add(root);
          }
          return path;
    }
}
