class Solution {
    Map<Integer,Integer> map = new HashMap<>();    //将坐标信息存放在map中，以便取出下标
    public TreeNode helper(int[] preorder, int p_l,int p_r,int[] inorder,int i_l,int i_r){
         if(p_l>p_r) return null;
         int val = preorder[p_l];
         TreeNode root = new TreeNode(val);
         int split_index = map.get(val);  //获取根节点的索引，以便将左右两边的节点进行分割
         int left_length = split_index-i_l; //获取左边节点的个数
         root.left = helper(preorder, p_l+1,  p_l+left_length , inorder, i_l, split_index-1) ; //左节点开始的坐标
         root.right = helper(preorder, p_l+left_length+1, p_r, inorder, split_index+1, i_r);  //右节点开始的坐标
         return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
          int n = preorder.length;
          int m = inorder.length;
          for(int i=0; i<m; i++){
               map.put(inorder[i], i);
          }
          return helper(preorder,0, n-1, inorder, 0, m-1);   //这里注意是n-1, m-1，刚开始写成了n,m
    }
}
