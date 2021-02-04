class Solution {
    ///////////////层序遍历，取出集合中的最后一个元素，即为右视图
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> res = new ArrayList<>();
         if(root==null) return res;
         LinkedList<TreeNode> queue = new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
             int size = queue.size();
             res.add(queue.get(size-1).val);
             for(int i=0; i<size; i++){
                  TreeNode node = queue.poll();
                  if(node.left!=null) queue.offer(node.left);
                  if(node.right!=null) queue.offer(node.right);
             }
         }
         return res;
    }

    ////////////////官方解法  深度优先遍历
    public List<Integer> rightSideView(TreeNode root) {
          Map<Integer,Integer> right = new HashMap<Integer,Integer>();
          Stack<TreeNode> stack = new Stack<>();
          Stack<Integer> depth = new Stack<>();
          int maxDepth = -1;  //记录二叉树的最大深度
          stack.push(root);
          depth.push(0);
          while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                int dep = depth.pop();
                maxDepth = Math.max(maxDepth,dep);
                if(node!=null){
                    if(!right.containsKey(dep)){
                         right.put(dep, node.val);
                    }
                    stack.push(node.left);
                    stack.push(node.right);
                    depth.push(dep+1);
                    depth.push(dep+1);
                }
          }
          List<Integer> res = new ArrayList<>();
          for(int i=0; i< maxDepth; i++){
                res.add(right.get(i));
          }
          return res;
    }

   //////////////广度优先遍历，主要将栈修改为队列的形式
   public List<Integer> rightSideView(TreeNode root){
         Map<Integer,Integer> right = new HashMap<Integer,Integer>();
          LinkedList<TreeNode> queue = new LinkedList<>();
          LinkedList<Integer> depth = new LinkedList<>();
          int maxDepth = -1;  //记录二叉树的最大深度
          queue.offer(root);
          depth.offer(0);
          while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                int dep = depth.poll();
                maxDepth = Math.max(maxDepth,dep);
                if(node!=null){
                    right.put(dep, node.val);   //不需要判断，因为会最后的元素覆盖之前的元素
                    queue.offer(node.left);
                    queue.offer(node.right);
                    depth.offer(dep+1);
                    depth.offer(dep+1);
                }
          }
          List<Integer> res = new ArrayList<>();
          for(int i=0; i< maxDepth; i++){
                res.add(right.get(i));
          }
          return res;
   } 
  
}
