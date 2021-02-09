class Solution {
      public ListNode rotateRight(ListNode head, int k) {
         if(head==null || head.next==null) return head;
         int length = 0;
         ListNode t = head;
         while(t!=null){
             length++;
             t = t.next;
         }
         if(k>=length){
            k = k%length;     //这一块是重点，不然在k值很大的情况下会出现超出时间限制，由于是循环的，所以k与k%length旋转的结果是一样的
         }
         ListNode dymm = new ListNode(-1);
         dymm.next = head;
         ListNode prev = dymm;
         for(int i=0; i<k; i++){
            ListNode tail = dymm.next;  //记录尾结点
            ListNode t_prev = dymm;     //记录尾结点的前置节点
            while(tail.next!=null){   //获取尾结点和其前置节点
                tail = tail.next;
                t_prev = t_prev.next;
            }
            ListNode nxt = prev.next;
            prev.next = tail;   //指向尾结点
            t_prev.next = null;  //其前置节点为空
            tail.next = nxt;
         }
         return dymm.next;
    }
   
   ////////////////////优化
    public ListNode rotateRight(ListNode head, int k){
        if(head==null || head.next==null) return head;
        int length = 0;
        ListNode t = head;
        while(t!=null){
             length++;
             t = t.next;
        }
        if(k>=length){
           k = k%length;
        }
        if(k==0) return head;
        ListNode dymm = new ListNode(-1);
        dymm.next = head;
        ListNode cur = head;
        for(int i=1; i<(length-k); i++){    //获取后面的节点[1,2,3,4,5] k=2，4,5,1,2,3 从节点3开始断开
             cur = cur.next;
        }
        ListNode nxt = cur.next;
        ListNode tail = nxt;
        while(tail.next!=null){
            tail = tail.next;
        }
        cur.next = null;   //将头结点链接到后面的节点
        dymm.next = nxt;
        tail.next = head;
         return dymm.next;
   }
}
