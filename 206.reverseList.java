class Solution {
    public ListNode reverseList(ListNode head) {  //需要三个指针，prev指向当前指针的前面节点，head指向当前节点，nxt指向当前指针的后一个节点。
           ListNode prev = null;  //初始化前指针为null
           while(head!=null){  //注意为head!=null
               ListNode nxt = head.next;
               head.next = prev;
               prev = head;
               head = nxt;
           }
           return prev; //返回前一个指针
    }
}
