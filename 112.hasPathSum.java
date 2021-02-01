class Solution {
public boolean hasPathSum(TreeNode root, int targetSum) {  //递归遍历
             if(root==null) return false;
             if(targetSum == root.val && root.left==null && root.right==null) return true;  //当为叶子节点，并且综合等于targetSum时返回，刚开始写成了targetSum==0，这是错误的，因为下面的递归时root.left，所以这里需要判断left的根节点。
             return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val); //判断左节点和右节点
    }
    }
