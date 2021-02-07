class Solution {
     ////////通过中序遍历，得到的集合肯定是有序的，所以通过遍历集合判断集合是否有序就行
     List<Integer> list = new ArrayList<>();
    public void inorder(TreeNode root){
         if(root==null) return;
          inorder(root.left);
          list.add(root.val);
          inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
           inorder(root);
           for(int i=0; i<list.size()-1; i++){
               if(list.get(i+1)<=list.get(i)) return false;
           }
           return true;
    }

    ////////错误思路，这种思路在以下这种情况下会报错
    //        5
    //    3       6
    //  2    6  3   7 
    //  这种情况，对于每个根节点来说都满足要求，但是对于节点6来说不满足要求，所以说需要往左走需要有一个上限不能超过，往右走需要有一个下限不能超过
    public boolean  isValidBST(TreeNode root){
             if(root==null) return true;
             if(root.left != null) {
                   if(root.left.val >= root.val) return false;
             }
             if(root.right != null) {
                   if(root.right.val <= root.val) return false;
             }
             return isValidBST(root.left) && isValidBST(root.right);
    }

    ////////////正确的递归方式
    public boolean isValidBST(TreeNode root){
           if(root==null) return true;
           return isValidBST(root, null ,null);     
    }

    public boolean isValidBST(TreeNode root,Integer max, Integer min){
         if(root==null) return true;
         if(max!=null && root.val >= max) return false;
         if(min!=null && root.val <= min) return false;
         return  isValidBST(root.left, root.val, min) && isValidBST(root.right, max, root.val);  //左子树有一个上限，上限值为root.val，下限值为min
    }

    //////迭代的方式
    public boolean isValidBST(TreeNode root){
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<>();
        //int val = Integer.MIN_VALUE;   //这个的写法有问题，在输入节点为[-2147483648]时，返回为false，实际为true
        double val = -Double.MAX_VALUE; 
        TreeNode node = root;
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(node.val <= val) return false;   //也就是遍历的顺序是有序的
            val = node.val;    //记录当前节点的值，以便与下一次循环进行比较
            node = node.right;
        }
        return true;
    }
    
}
