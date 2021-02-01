class Solution {
public boolean hasPathSum(TreeNode root, int targetSum) {  //递归遍历
             if(root==null) return false;
             if(targetSum == root.val && root.left==null && root.right==null) return true;  //当为叶子节点，并且综合等于targetSum时返回，刚开始写成了targetSum==0，这是错误的，因为下面的递归时root.left，所以这里需要判断left的根节点。
             return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val); //判断左节点和右节点
    }
    }

//非递归遍历
 public boolean hasPathSum(TreeNode root, int targetSum) {   
           if(root==null) return false;
           LinkedList<TreeNode> queue = new LinkedList<>();   //简单的层序遍历方式
           LinkedList<Integer> q_val = new LinkedList<>();   //多添加一个队列用来存放树计算过程中的累加和，最后生成的树是一个累加和树
           queue.add(root);
           q_val.offer(root.val);
           while(!queue.isEmpty()){
                 int size = queue.size();
                 for(int i=0; i<size; i++){
                       TreeNode node = queue.poll();
                       int temp = q_val.poll();
                       if(temp==targetSum && node.left==null && node.right==null) return true;
                       if(node.left!=null){
                           queue.offer(node.left); q_val.offer(temp+node.left.val);}  //将当前节点的值和左节点的值相加放入队列中
                       if(node.right!=null){
                           queue.offer(node.right); q_val.offer(temp+node.right.val);}
                 }
           }
           return false;
    }
