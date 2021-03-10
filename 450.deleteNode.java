class Solution {
    /////////通过率100%，
    List<Integer> list = new ArrayList<>();
    public void inorder(TreeNode root){
          if(root==null) return;
          inorder(root.left);
          list.add(root.val);
          inorder(root.right);
    }
    public TreeNode deleteNode(TreeNode root, int key) {
           inorder(root);
           list.remove((Integer)key);
           return buildTree(0, list.size()-1);
    }
    public TreeNode buildTree(int left, int right){
           if(left>right) return null;
           int mid = (left+right)/2;
           TreeNode root = new TreeNode(list.get(mid));
           root.left = buildTree(left,mid-1);
           root.right = buildTree(mid+1,right);
           return root;
    }

   /////////////递归写法，通过率100%，空间复杂度为o(n)
   public int successor(TreeNode root){   //后继节点，代表中序遍历序列的下一个节点
          root = root.right;
          while(root.left!=null){
              root = root.left;
          }
          return root.val;
   }
   public int predecessor(TreeNode root){  //前驱节点，代表中序遍历的前一个节点
          root = root.left;
          while(root.right!=null){
               root = root.right;
          }
          return root.val;
   }
   public TreeNode deleteNode(TreeNode root, int key){
        if(root==null) return null;
        if(root.val>key) root.left = deleteNode(root.left, key); //删除的节点在左侧
        else if(root.val<key) root.right = deleteNode(root.right, key);  //删除的节点在右侧
        else{   //删除的是根节点
            if(root.left==null && root.right==null) return null;   //如果是叶子节点，那么直接删除叶子节点
            else if(root.right!=null){    //删除的不是叶子节点，并且拥有右节点，则该节点可以由该节点的后继节点代替
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }else{   //删除的不是叶子节点，并且没有右节点有左节点，则该节点可以由该节点的前驱节点来代替
                 root.val = predecessor(root);
                 root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
   } 
}

