class Solution {
    ////////////深度优先遍历
    public int sumNumbers(TreeNode root) {
         return DFS(root,0);
    }

    public int DFS(TreeNode root, int temp){
         if(root=null) return 0;
         int res = temp*10+root.val;
         if(root.left==null && root.right==null) return res;
         return DFS(root.left,res) + DFS(root.right,res);
    }
 

    ///////////广度优先遍历
    public int sumNumbers(TreeNode root){
         if(root==null) return 0;
         int res = 0;
         LinkedList<TreeNode> queue = new LinkedList<>();
         LinkedList<Integer> value = new LinkedList<>();
         queue.add(root);
         value.add(root.val);
         while(!queue.isEmpty()){
              int size = queue.size();
              for(int i=0; i<size; i++){
                  TreeNode node = queue.poll();
                  int temp = value.poll();
                  if(node.left==null && node.right==null) res+=temp;   //如果到达叶子节点，那么将节点和进行相加
                  if(node.left!=null){queue.add(node.left); value.add(temp*10+node.left.val);}
                  if(node.right!=null){queue.add(node.right); value.add(temp*10+node.right.val);}
              }
         }
         return res;
   }    
}
