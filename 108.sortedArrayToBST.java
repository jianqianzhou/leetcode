class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
          if(nums==null || nums.length==0) return null;
          TreeNode node = helper(nums, 0, nums.length-1);
          return node;
    }

    public TreeNode helper(int[] nums, int start, int end){
         if(start>end) return null;    //忘记写递归的退出条件了，当start>end时，需要退出递归，不然会导致一直不断在循环
         int mid = (start+end)/2;
         TreeNode root = new TreeNode(nums[mid]);
         root.left =  helper(nums, start, mid-1);  //是mid-1，不是mid，因为mid已经作为了根节点了，不需要再次参与左节点和右节点的构造中
         root.right = helper(nums, mid+1, end);
         return root;
    }
    
}
