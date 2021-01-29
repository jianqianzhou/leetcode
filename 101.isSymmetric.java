class Solution {
    /////////////////递归方式实现
    public boolean isSymmetric(TreeNode root) {
          return isSameTree(root,root);   
    }

     public boolean isSameTree(TreeNode p, TreeNode q) {
           if(p==null && q==null) return true;
           if(p==null && q!=null) return false;
           if(p!=null && q==null) return false;
           if(p.val != q.val ) return false;
           return isSameTree(p.left,q.right) && isSameTree(p.right,q.left);  //与前者判断相同的树有所差别，不是isSameTree(p.left, q.left) && isSameTree(p.right, q.right); 对称判断
    }


   ///////////////////////////////非递归方式，分别使用两个队列，存放一颗树的两边
   public boolean isSymmetric(TreeNode root){
          if(root==null) return true;
          LinkedList<TreeNode> queue1 = new LinkedList<>();
          LinkedList<TreeNode> queue2 = new LinkedList<>();
          queue1.add(root);
          queue2.add(root);
          while(!queue1.isEmpty() && !queue2.isEmpty()){
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                if(node1==null && node2==null) continue;
                if(node1==null || node2==null) return false;
                if(node1.val!=node2.val) return false;
                queue1.add(node1.left);
                queue1.add(node1.right);
                queue2.add(node2.right);
                queue2.add(node2.left);
          }
          return queue1.isEmpty() && queue2.isEmpty();
   }


   /////////////////////////////非递归方式，优化，使用一个队列，存放一颗树
   public boolean isSymmetric(TreeNode root){
         if(root==null) return true;
         LinkedList<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         queue.add(root);  //这里注意，需要添加root两次，一边判断
         while(!queue.isEmpty()){
               TreeNode node1 = queue.poll();  //同时poll两个节点，这两个节点值需要一致才能相等
               TreeNode node2 = queue.poll();
               if(node1==null && node2==null) continue;  //因为下面没有判断是否为null都加入到了队列中，所以在这里需要判断，当两个都为null时，表示叶子节点了，需要continue继续判断别的节点。
               if( (node1==null || node2==null) || (node1.val!=node2.val)) return false; //当一个节点为null，另一个节点不为null，或者两个节点的值不相等时，返回为false
               queue.add(node1.left);    //不用判断是否为空再加入，不管是否为null都需要加入到队列中，因为后续会有判断
               queue.add(node2.right);   //加入顺序，先node1的左节点，再加入node2的右节点，判断是否对称
               queue.add(node1.right);   
               queue.add(node2.left);   //先加入node1的右节点，再加入node2的左节点，判断是否对称
         }
         return queue.isEmpty();
   }
  
}
