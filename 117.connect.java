class Solution {
    ////////////空间复杂度为O(N)
    public Node connect(Node root){
         if(root==null) return null;
         LinkedList<Node> queue = new LinkedList<>();
         queue.offer(root);
         while(!queue.isEmpty()){
             int size = queue.size();
             for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(i<size-1) node.next = queue.peek(); //链接到queue。peek()节点
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
         }
         return root;
    }

    //////////////////空间负责度为O(1)   把每一层当做一个链表来处理
    //                      1
    //                    /  \
    //                   2 -->3
    //                  / \    \
    //  dymm(0)(pre)   5   6    4
    //  cur
    //
    //循环遍历链表的同时，将下一层的树节点进行连接
    //
    public Node connect(Node root) {
         if(root==null) return null;
         Node nextStart = root;
         while(nextStart!=null){
            Node dymm = new Node(0);
            Node pre = dymm;
            Node cur = nextStart;
            while(cur!=null){
                if(cur.left!=null){       //左节点不为null
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if(cur.right!=null){   //右节点不为null
                   pre.next = cur.right;
                   pre = pre.next;
                }
                cur = cur.next;
            }
            nextStart = dymm.next;  //下一次循环的起始节点
        }
        return root;
    }
}
