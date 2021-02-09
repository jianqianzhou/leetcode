class Solution {
   public ListNode reverseBetween(ListNode head, int m, int n) {
         if(head==null) return head;
         ListNode dymm = new ListNode(-1);
         dymm.next = head;
         ListNode p = head;
         ListNode prev = dymm;     //[1,2,3,4,5],m=2,n=4
         for(int i=1; i<m; i++){
             prev = prev.next;     //获取p节点的前置节点，为1
             p = p.next;          //获取起始节点，为2
         }
         ListNode q = p;      //从起始节点开始获取末尾节点
         for(int i=0; i<n-m; i++){ 
             q = q.next;     //获取到了后置节点
         }
         ListNode nxt = q.next;  //记录后置节点的下一个节点
         ListNode[] lists = reverse(p,q);    //反转p和q之间的节点
         prev.next = lists[0];    //链接节点
         lists[1].next = nxt;
         return dymm.next;
    }

    public ListNode[] reverse(ListNode p, ListNode q){
          ListNode t = p;   //记录当前头结点，新的尾结点
          ListNode prev = p;
          p = p.next;
          while(prev!=q){
               ListNode nxt = p.next;
               p.next = prev;
               prev = p;
               p = nxt;
          }
          return new ListNode[]{prev,t};  //返回新的头结点和尾结点
    }
}
