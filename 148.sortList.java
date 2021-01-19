class Solution {
     //流程：（1）找到链表的中点，以中点为分界，将链表拆分成两个子链表，寻找链表中点可以使用快慢指针的方式，快指针每次移动两步，慢移动一步，当快指针到达链表末尾时，慢指针指向链表的中点
     //（2）对两个子链表分别排序
     //（3）将两个排序后的子链表合并，得到完整的排序后的链表
     public ListNode sortList(ListNode head) {
         return sortList(head,null);
    }
    public ListNode sortList(ListNode head, ListNode tail){
         if(head==null) return head;  //当节点链表为空
         if(head.next==tail){   //当节点链表个数为1       这两种情况都需要终止递归，不需要对链表进行拆分和排序
             head.next = null;
             return head;
         }
         ListNode fast = head; ListNode slow = head;   //快慢指针方式，获取中间节点，快慢指针获取中间节点的方式与常见的方式有区别
         while (fast != tail) {   //主要是判断方式
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {    //这里加了一个判断
                fast = fast.next;
            }
         }
         ListNode mid = slow;    //慢指针所在的就是中间节点
         ListNode list1 = sortList(head,mid);  //归并排序
         ListNode list2 = sortList(mid,tail);  //归并排序
         ListNode list = merge(list1,list2); //合并两个有序的链表
         return list;
    }
    public ListNode merge(ListNode l1, ListNode l2){
             ListNode dymm = new ListNode(-1);
             ListNode h = dymm;
             while(l1!=null && l2!=null){
                 if(l1.val>l2.val){
                      h.next = l2;
                      l2 = l2.next;
                      h = h.next;
                 }else{
                      h.next = l1;
                      l1 = l1.next;
                      h = h.next;
                 }
             }
             if(l1!=null) h.next = l1;
             else if(l2!=null) h.next = l2;
             return dymm.next;
    }
}
