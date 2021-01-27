class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          List<List<Integer>> ans = new ArrayList<>();
          LinkedList<TreeNode> queue = new LinkedList<>();
          if(root==null) return ans;
          queue.add(root);
          int odd = 1;
          while(!queue.isEmpty()){
               int size = queue.size();
               LinkedList<Integer> level = new LinkedList<>();   //注意这里是与层序遍历的区别点
               for(int i=0; i<size; i++){
                     TreeNode node = queue.poll();
                     if(odd%2!=0)
                          level.add(node.val);   //当为奇数层时，正常添加到LinkedList中
                      else
                          level.addFirst(node.val);   //当为偶数层时，一直不断往前添加，可实现逆序输出
                     if(node.left!=null){ queue.add(node.left); }
                     if(node.right!=null){ queue.add(node.right); }  
               }
               ans.add(level);
               odd++;  //添加完后，加上一层
          }
          return ans;
    }
}
