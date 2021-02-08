class Solution {
      //////比较挫的方式，采用两个链表，一个存小于val，一个存大于3的，然后将两个链表进行合并
      public ListNode partition(ListNode head, int x) {
          ListNode dymm = new ListNode(-1);  //申请一个新的链表
          ListNode node = dymm;
          ListNode dy = new ListNode(-1);  //设置哨兵节点
          dy.next = head;
          ListNode prev = dy;
          while(head!=null){
               if(head.val<x){
                    node.next = head;  //采用尾插法
                    prev.next = head.next;
                    head = head.next;
                    node = node.next;
                    node.next = null;
                    head = prev.next;
                    if(head==null) break;
               }else{    //注意这里需要else语句
                  head = head.next;
                  prev = prev.next;
               }
          }
          node.next = dy.next;  //链接大于3的链表
          return dymm.next;   //返回第一个链表节点
    }

   ////////////////////////官网解法
   public ListNode partition(ListNode head, int x){
       ListNode small = new ListNode(0);
       ListNode s = small;
       ListNode large = new ListNode(0);
       ListNode l = large;
       while(head!=null){
           if(head.val < x){
              s.next = head;
              s = s.next;
           }else{
              l.next = head;
              l = l.next;
           }
           head = head.next;
           s.next = null;
           l.next = null;
       }
      s.next = large.next;
      l = null;
      return small.next;
   }




   /////////////////////或者
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
