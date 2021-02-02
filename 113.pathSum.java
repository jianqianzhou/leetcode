class Solution {
    ////////////////////////深度优先遍历，采用的是回溯的思路， 递归
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         LinkedList<Integer> track = new LinkedList<>();
         dfs(track, root, targetSum, 0);      
         return res;
    }
    public void dfs(LinkedList track, TreeNode node, int targetSum, int curSum){
           if(node==null) return;
           track.add(node.val);     //这里刚开始添加的位置不对，导致最后一个节点node没有添加到
           if(node.left==null && node.right==null && curSum+node.val==targetSum){
               res.add(new LinkedList(track));
           }
           dfs(track, node.left, targetSum, curSum+node.val);        //dfs左边的节点
           dfs(track, node.right, targetSum, curSum+node.val);    //dfs右边的节点
           track.removeLast();
    }


   ////////////////广度优先遍历，非递归方式
   class Solution {
   public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<List<Integer>> res = new ArrayList<>();
         if(root==null) return res; 
         LinkedList<TreeNode> queue = new LinkedList<>();
         LinkedList<Integer> q_val = new LinkedList<>();
         Map<TreeNode,TreeNode> map = new HashMap<TreeNode, TreeNode>();
         queue.add(root);
         q_val.add(root.val);
        //  map.put(root,null);   //不需要先放置根节点
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i=0; i<size; i++){
                 TreeNode node = queue.poll();
                 int temp = q_val.poll();
                 if(node.left==null && node.right==null && temp==targetSum){
                       LinkedList<Integer> lists = new LinkedList<>();
                       while(node!=null){  //不断循环获取父节点的值
                             lists.addFirst(node.val);  //往前添加
                             node = map.get(node);
                       }
                        res.add(lists);
                 }else{
                   if(node.left!=null){
                      queue.offer(node.left); 
                      q_val.offer(temp+node.left.val);
                      map.put(node.left,node);  //存放的是<子节点,父节点>
                   }
                   if(node.right!=null){
                       queue.offer(node.right); 
                       q_val.offer(temp+node.right.val); 
                       map.put(node.right,node);  
                   }
                }
             }
         }
         return res;
   }
