class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         if(l1==null && l2==null) return l1;
         ListNode dymm = new ListNode(-1); //申请一个新的起始节点
         ListNode p = dymm;
         while(l1!=null && l2!=null) {
              if(l2.val>l1.val){
                   p.next = l1; //这里不需要使用 p.next  = new ListNode(l1.val); 直接使用p.next = l1，效率提升明显
                   l1 = l1.next;
              }else{
                  p.next = l2;
                  l2 = l2.next;
              }
              p = p.next;
         }
         if(l1!=null) p.next = l1; //如果l1!=null，那么将l1接在p后面
         if(l2!=null) p.next = l2;
         return dymm.next;
    }
}
