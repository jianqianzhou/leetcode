class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
             ListNode dymm = new ListNode(-1);
             ListNode prev = dymm;
             int carry = 0;
             while(l1!=null || l2!=null){
                   int a1 = l1==null?0:l1.val;
                   int a2 = l2==null?0:l2.val;
                   int temp = a1 + a2 + carry;
                   if(temp>=10) {carry = 1; temp = temp%10;}else{carry=0;}
                   ListNode node = new ListNode(temp);
                   prev.next = node;
                   prev = prev.next;
                   if(l1!=null) l1 = l1.next;
                   if(l2!=null) l2 = l2.next;
             }
             if(carry==1){
                 ListNode node = new ListNode(1); 
                 prev.next=node;
                 prev = null;
              }
             return dymm.next;
    }
}
