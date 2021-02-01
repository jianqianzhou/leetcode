class Solution {
    public TreeNode sortedListToBST(ListNode head) {
             TreeNode node = helper(head, null);  //end为null节点
             return node;
    }
    public TreeNode helper(ListNode start, ListNode end){
          if(start==end) return null;    //递归退出条件，start==end退出
          ListNode fast = start;
          ListNode slow = start;
          while(fast.next!=end && fast.next.next!=end){  
               slow = slow.next;
               fast = fast.next.next;
          }                                    //获取链表的中间节点，通过快慢指针来获取
          TreeNode root = new TreeNode(slow.val);
          root.left = helper(start,slow);    //注意这里与108题之前的区别，108为（start，prev）不会包括slow节点，为slow的前面一个节点，这里是因为end为null，与108的end为nums.length-1不同，区间范围为[head,null)，[start,slow)，[start.next,end)，而108题为[0,nums.length-1]，都为闭区间，所以在左节点需要去掉最后一个值为(start,mid-1)，而这里不需要
          root.right = helper(slow.next,end);
          return root;
    }
}
