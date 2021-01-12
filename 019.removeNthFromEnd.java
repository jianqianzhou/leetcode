class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
          ListNode dymm = new ListNode(0);  //设置哨兵节点，为了防止删除第一个节点时，出现空指针问题
          dymm.next = head;
          ListNode p = head;
          int length = 0;
          while(p!=null){
              length++;
              p = p.next;  
          }
          p = dymm;
          int i = length-n; //为了找到删除节点的前面一个节点位置
          while(i>0){
              p = p.next;
              i--;
          }
          p.next = p.next.next; //删除节点
          return dymm.next;
    }
}
