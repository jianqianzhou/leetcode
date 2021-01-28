class Solution {
    /////深度优先搜索  递归方式
    public boolean isSameTree(TreeNode p, TreeNode q) {
           if(p==null && q==null) return true;   //表示判断到最后的节点了，都为null，判断完成了，返回true
           if(p==null && q!=null) return false;  
           if(p!=null && q==null) return false;   //其中一个节点为null，另一个不为null，则返回false
           if(p.val != q.val ) return false;      //两个值不相等返回false
           return isSameTree(p.left,q.left) && isSameTree(p.right,q.right); //递归不断判断
    }

    ////////广度优先搜索，非递归方式
    public boolean isSameTree(TreeNode p, TreeNode q) {
          if(p==null && q==null) return true;
          else if(p==null || q==null) return false;
          LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
          LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
          queue1.add(p);
          queue2.add(q);
          while(!queue1.isEmpty() && !queue2.isEmpty()){
                TreeNode n1 = queue1.poll();
                TreeNode n2 = queue2.poll();
                if(n1.val!=n2.val) return false;
                TreeNode l1 = n1.left, r1 = n1.right, l2 = n2.left, r2 = n2.right;
                if(l1==null ^ l2==null) return false;  //这里使用的符号是^，而不是||
                if(r1==null ^ r2==null) return false;  // ||
                if(l1!=null){
                     queue1.add(l1);
                }
                if(l2!=null){
                     queue2.add(l2);
                }
                if(r1!=null){
                     queue1.add(r1);
                }
                if(r2!=null){
                     queue2.add(r2);
                }
          }
          return  queue1.isEmpty() && queue2.isEmpty();
    }
}
