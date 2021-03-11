class Solution {
      public ListNode oddEvenList(ListNode head) {   //奇数偶数链表
          if(head==null || head.next==null) return head;
          ListNode odd = head;
          ListNode even = head.next;   //指向奇数头
          ListNode even_head = even;  //指向偶数头
          while(even!=null && even.next!=null){   //even!=null是1-2-3-4-5链表为奇数的判断条件  even.next!=null 是1-2-3-4-5-6链表为偶数的判断条件
              odd.next = even.next;   //奇数和偶数交替进行
              odd = odd.next;
              even.next = odd.next;
              even = even.next;
          }
          odd.next = even_head;  //奇数的尾结点信息链接到偶数的头结点
          return head;     
      }
}
