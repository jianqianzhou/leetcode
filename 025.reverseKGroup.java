class Solution {
   ////////////////////////////////////////时间37%
   public ListNode reverseKGroup(ListNode head, int k) {
          ListNode dymm = new ListNode(-1);
          dymm.next = head;
          ListNode tail = head;
          ListNode pre = dymm;
          int i=1;
          while(tail!=null){
               if(i%k==0){
                   ListNode [] nodes = reverse(head,tail);
                   head = nodes[0];
                   tail = nodes[1];
                   pre.next = head;
                   head = tail.next;
                   pre = tail;
               }
               tail = tail.next;
               i++;
          }
          return dymm.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode p = head;
        while(prev!=tail){
            ListNode nxt = p.next;
            p.next = prev;
            prev = p;
            p = nxt;
        }
        return new ListNode[]{tail,head};
    }
}

////////////////////////////////////////////////////////官方解法，超过100%
        public ListNode reverseKGroup(ListNode head, int k) {
             ListNode dymm = new ListNode(-1);
             dymm.next = head;
             ListNode pre = dymm;
             while(head!=null){
                 ListNode tail = pre;
                 for(int i=0; i<k; i++){  //还有使用了for循环
                      tail = tail.next;
                      if(tail==null){
                          return dymm.next;
                      }
                 }
                 ListNode nxt = tail.next;  
                 ListNode [] nodes = reverse(head,tail);
                 head = nodes[0];
                 tail = nodes[1];
                 pre.next = head;
                 tail.next = nxt;   //主要加了这句话
                 pre = tail;
                 head = tail.next;
             }
             return dymm.next;
        }
        public ListNode[] reverse(ListNode head, ListNode tail){
             ListNode prev = tail.next;
             ListNode p = head;
             while(prev!=tail){
                 ListNode nxt = p.next;
                 p.next = prev;
                 prev = p;
                 p = nxt;
             }
             return new ListNode[]{tail,head};
        }
}
