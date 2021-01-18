public class Solution {
    //当发现 slow 与 fast 相遇时，fast重新指向链表头部；随后，它和slow 每次向后移动一个位置。最终，它们会在入环点相遇。
    public ListNode detectCycle(ListNode head) {
             if(head==null) return head;
             ListNode fast = head;
             ListNode slow = head;
             while(fast.next!=null && fast.next.next!=null){    
                fast = fast.next.next;
                slow = slow.next;
                if(fast==slow){ 
                    fast = head;
                    while(fast!=slow){
                        fast = fast.next;
                        slow = slow.next;
                    }
                    return fast;
                }
             }
             return null;
    }
}
