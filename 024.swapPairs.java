class Solution {
    public ListNode swapPairs(ListNode head) {
         ListNode dymm = new ListNode(-1);
         dymm.next = head;
         ListNode prev = dymm;
         while(head!=null && head.next!=null){
                ListNode f =  head;
                ListNode s = head.next;
               
                //互换值，指针互换
                prev.next = s;
                f.next = s.next;
                s.next = f;
                
                //移动指针
                prev = f;
                head = f.next;
 
         }
         return dymm.next;     
    }
}
