class Solution {
    public ListNode removeElements(ListNode head, int val) {
          ListNode dymm = new ListNode(-1);
          dymm.next = head;
          ListNode prev = dymm;
          ListNode curr = head;
          while(curr!=null){
               if(curr.val==val){   //在当前值相等的情况下，不需要移动前指针，因为后面一个元素有可能也是相等的
                  prev.next = curr.next;
               }else{
                   prev = curr;  //不相等的情况下才移动前指针
               }
               curr = curr.next;
          }
          return dymm.next;
    }
}
