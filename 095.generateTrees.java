class Solution {
      public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = helper(1,n);
        return res;
    }
    public List<TreeNode> helper(int start, int n){
        List<TreeNode> res = new ArrayList<>();
        if(start>n){ 
            res.add(null);    //这一步不可省略，非常重要
            return res;
        }
        for(int i=start; i<=n; i++){
            List<TreeNode> lefts = helper(start, i-1);
            List<TreeNode> rights = helper(i+1,n);

            for(int k=0; k < lefts.size(); k++){   //获得所有可行的左子树和可行的右子树，那么最后一步我们只要从可行左子树集合中选一棵，再从可行右子树集合中选一棵拼接到根节点上，并将生成的二叉搜索树放入答案数组即可。
                for(int j=0; j< rights.size(); j++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(k);
                    root.right = rights.get(j);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
