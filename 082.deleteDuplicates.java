class Solution {
    public ListNode deleteDuplicates(ListNode head) {
          ListNode dymm = new ListNode(-1);
          if(head==null || head.next==null) return head;
          dymm.next = head;
          ListNode prev = dymm;
          ListNode cur = head;
          while(cur!=null && cur.next!=null){
             if(cur.val==cur.next.val){
                 while(cur.next!=null && cur.val==cur.next.val){ //注意[1,1]的情况如果不对cur.next!=null进行判断会出现空指针
                     cur = cur.next;   //不断循环直至找到不相等的元素
                 }
                 prev.next = cur.next; //找到了不相等的元素后，删除不相等的元素节点
                 cur = cur.next; //这里需要注意移动cur的节点，因为cur节点也是重复的，所以需要移动到写一个节点
             }else{
                 cur = cur.next;    //如果不相等则正常移动
                 prev = prev.next;
             }
          }
          return dymm.next;
    }

   ////////////////////或者
    public ListNode deleteDuplicates(ListNode head) {
          ListNode dymm = new ListNode(-1);
          if(head==null || head.next==null) return head;
          dymm.next = head;
          ListNode prev = dymm;
          ListNode cur = head;
          while(cur!=null && cur.next!=null){
             if(cur.val==cur.next.val){
                 while(cur.next!=null && cur.val==cur.next.val){ //注意[1,1]的情况如果不对cur.next!=null进行判断会出现空指针
                     cur = cur.next;   //不断循环直至找到不相等的元素
                 }
                 prev.next = cur.next; //找到了不相等的元素后，删除不相等的元素节点
             }else{
                 prev = prev.next;
             }
             cur = cur.next;  //将这一步提取出来
          }
          return dymm.next;
    }
}
