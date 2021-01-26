class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> ans = new ArrayList<>();
          LinkedList<TreeNode> queue = new LinkedList<>();
          if(root==null) return ans;
          queue.add(root);
          while(!queue.isEmpty()){
               int size = queue.size();
               List<Integer> level = new ArrayList<>();
               for(int i=0; i<size; i++){ 
                     TreeNode node = queue.poll();
                     level.add(node.val);
                     if(node.left!=null){ queue.add(node.left); }
                     if(node.right!=null){ queue.add(node.right); }    //这里刚开始写错了，写成了else if，导致出错
               }
               ans.add(level);
          }  
          return ans;
    }
}
