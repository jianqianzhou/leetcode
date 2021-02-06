class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode helper(int[] inorder,int i_l,int i_r, int[] postorder,int p_l,int p_r){
           if(i_l>i_r) return null;     //退出递归的条件
           int val = postorder[p_r];
           TreeNode root = new TreeNode(val);
           int split_index = map.get(val);
           int left_length = split_index-i_l;
           root.left = helper(inorder, i_l, split_index-1,postorder,p_l, p_l+left_length-1); //这里需要减1
           root.right = helper(inorder, split_index+1, i_r, postorder,p_l+left_length,p_r-1);
           return root;      
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
            int n = inorder.length;     //n==m，设置一个长度就行
            int m = postorder.length;
            for(int i=0; i<inorder.length; i++){
                 map.put(inorder[i],i);
            }
            return helper(inorder,0,n-1,postorder,0,m-1);   //记住要减去一
    }
}
