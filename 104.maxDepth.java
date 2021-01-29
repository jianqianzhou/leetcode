class Solution {
    //递归遍历,通过率100%
    public int maxDepth(TreeNode root) {
         if(root==null) return 0;
         if(root.left==null && root.right!=null) return maxDepth(root.right)+1;  
         if(root.left!=null && root.right==null) return maxDepth(root.left)+1;
         if(root.left==null && root.right==null) return 1;
         return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    //////优化后的递归遍历
    public int maxDepth(TreeNode root){
          if(root==null){
               return 0;
          }else{
               int leftHeight = maxDepth(root.left);
               int rightHeight = maxDepth(root.right);
               return Math.max(leftHeight, rightHeight)+1;
          }
    }

    //////////////非递归，即层序遍历有多少层
    public int maxDepth(TreeNode root){
         if(root==null) return 0;
         LinkedList<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         int level = 0;
         while(!queue.isEmpty()){
              int size = queue.size();
              for(int i=0; i<size; i++){
                  TreeNode node = queue.poll();
                  if(node.left!=null) queue.offer(node.left);
                  if(node.right!=null) queue.offer(node.right);
              }
              level++;
         }
         return level;
    }
}
