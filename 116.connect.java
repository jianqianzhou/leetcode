class Solution {
    public Node connect(Node root) {
          if(root==null) return null;
          LinkedList<Node> queue = new LinkedList<>();
          queue.add(root);
          while(!queue.isEmpty()){
             int size = queue.size();
             for(int i=0; i<size; i++){
                  Node node = queue.poll();
                  if(i<size-1)    //将前面几个节点连接，除去最后一个节点
                      node.next = queue.peek();
                  if(node.left!=null){ queue.offer(node.left);}
                  if(node.right!=null){ queue.offer(node.right);}
             }  
          }
          return root;     
    }
   
   ////////////////通过率100%,利用Node节点的特性，假设前一层已经链接好了
   public Node connect(Node root){
       if(root==null) return null;
       Node leftmost = root;  //用来记录最左边的起始节点
       while(leftmost.left!=null){   //注意条件判断不是leftmost!=null，而是leftmost.left!=null, 因为当前判断是在前一层已经链接好的情况下进行的
            Node node = leftmost;
            while(node!=null){
                node.left.next = node.right;   //对于同一个节点链接
                if(node.next!=null){           //对于不同节点之间的链接
                    node.right.next = node.next.left;
                }
                node = node.next;  //移动节点
            }
            leftmost = leftmost.left;   //指向最左边的节点
       }
       return root;
   }
}
