class Solution {
    //////////////////广度优先遍历
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
          LinkedList<List<Integer>> res = new LinkedList<>();
          if(root==null) return res;
          LinkedList<TreeNode> queue = new LinkedList<>();
          queue.add(root); 
          while(!queue.isEmpty()){
                LinkedList<Integer> lists = new LinkedList<>();
                int size = queue.size();
                for(int i=0; i<size; i++){
                     TreeNode node = queue.poll();
                     lists.add(node.val);
                     if(node.left!=null) queue.add(node.left);
                     if(node.right!=null) queue.add(node.right);
                }
                res.addFirst(lists);  //一直不断往前添加
          }
          return res;
    } 
}
