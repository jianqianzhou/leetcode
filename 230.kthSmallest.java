class Solution {
    //////////////递归方式
    List<Integer> lists = new ArrayList<>();
    public void inorder(TreeNode root){ 
            if(root==null) return;
            inorder(root.left);
            lists.add(root.val);
            inorder(root.right); 
    }
    public int kthSmallest(TreeNode root, int k) {
               inorder(root);
               return lists.get(k-1);   
    }


    ////////////////迭代方式
     public int kthSmallest(TreeNode root, int k){
         if(root==null) return -1;
         Stack<TreeNode> stack = new Stack<>();
         while(true){
             while(root!=null){
                 stack.push(root);
                 root = root.left;
             }
            root = stack.pop();
            if(--k==0) return root.val;
            root = root.right;
         }
    }
}
