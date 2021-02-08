class Solution {
    ////////////通过
    public ListNode deleteDuplicates(ListNode head) {
         ListNode dymm = new ListNode(-Integer.MAX_VALUE);
         dymm.next = head;
         ListNode prev = dymm;
         while(head!=null){
             if(head.val==prev.val){ 
                  ListNode t = head.next;
                  prev.next = t;
                  head = t;
             }else{
                  head = head.next;
                  prev = prev.next;
             }
         }
         return dymm.next;
    }

    ////////////官网解法，没有设置哨兵节点
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            if(cur.val==cur.next.val){
                 cur.next = cur.next.next;
            }else{
                 cur = cur.next;
            }
        }
        return head;
    }
}
