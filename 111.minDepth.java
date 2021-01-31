 刚开始在题意理解上有点问题，比如[1,2]的最小深度为2，不是1，因为当根节点不为空时，根节点不是叶子节点。
 //////////////////深度优先遍历
 public int minDepth(TreeNode root) {
            if(root==null)  return 0;
            if( (root.left == null) && (root.right == null)){ return 1;}  //当左右子树都为空时，树的长度返回1.
            else{
                int leftHeight = Integer.MAX_VALUE;
                int rightHeight = Integer.MAX_VALUE;
                if(root.left!=null){
                    leftHeight = minDepth(root.left);
                }
                if(root.right!=null){
                    rightHeight = minDepth(root.right);
                }
                 return Math.min(leftHeight,rightHeight)+1;
            }

    }
    
    /////////广度优先遍历
     public int minDepth(TreeNode root) {
            if(root==null)  return 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int ans = 1;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0; i<size; i++){
                    TreeNode node = queue.poll();
                    if(node.left==null && node.right==null){   //当左右节点都为空时，表示到达叶子节点
                        return ans;
                    }
                    if(node.left!=null) queue.offer(node.left);
                    if(node.right!=null) queue.offer(node.right);
                 }
                 ans++;
            }
            return ans;
    }
