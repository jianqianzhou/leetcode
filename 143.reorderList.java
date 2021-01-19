class Solution {
    //方法：（1）找到原链表中的中点
    //（2）将原链表的后半段反转
    //（3）将原链表的两端进行合并
    public void reorderList(ListNode head) {
          if(head==null || head.next==null) return;
          ListNode fast = head;
          ListNode slow = head;
          while(fast.next != null && fast.next.next!=null){
               fast = fast.next.next;
               slow = slow.next;
          }
          ListNode middle = slow;   //通过快慢指针找到中点
          ListNode l1 = head;
          ListNode l2 = reverse(middle.next); //反转中点后的一段
          middle.next = null;  //重点，将前半段进行分割，也即将middle.next设置为null
          merge(l1,l2);  //合并两端链表
    }
    public ListNode reverse(ListNode p){
         ListNode prev = null;
         ListNode curr = p;
         while(curr!=null){
             ListNode nxt = curr.next;
             curr.next = prev;
             prev = curr;
             curr = nxt;
         }
         return prev;
    }
    public ListNode merge(ListNode l1, ListNode l2){ //这种合并方式是采用了一个新的链表来进行的，也可以在原链表的基础上进行
           ListNode dymm = new ListNode(-1);
           ListNode p = dymm;
           while(l1!=null && l2!=null){
               p.next = l1;
               l1 = l1.next;
               p = p.next;
               p.next = l2;
               p = p.next;
               l2 = l2.next;
           }
           if(l1!=null) p.next = l1;
           else if(l2!=null) p.next = l2;
           return dymm.next;
    }


   /////////////////////////////////在原链表的基础上进行操作
   public ListNode merge(ListNode l1, ListNode l2){
         ListNode l1_t = l1;
         ListNode l2_t = l2;
         while(l1!=null && l2!=null){
              l1_t = l1.next;
              l2_t = l2.next;

              l1.next = l2;
              l1 = l1_t; 

              l2.next = l1;
              l2 = l2_t;
         }
         return l1;
   }
}
