class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
           ListNode tail = null; //采用头插法，也即不断往前加入元素， 尾插法不断往后插入元素  链表插入方法包括头插法和尾插法
           Stack<Integer> s1 = new Stack<>();
           Stack<Integer> s2 = new Stack<>();
           while(l1!=null){
               s1.push(l1.val);
               l1 = l1.next;
           }
           while(l2!=null){
              s2.push(l2.val);
              l2 = l2.next;
           }
           int carry = 0;
           while(!s1.isEmpty() || !s2.isEmpty()){
                 int a = s1.isEmpty()?0:s1.pop();   //可以将两个栈判断写在一个while循环中，不用while循环后再继续判断
                 int b = s2.isEmpty()?0:s2.pop();
                 int temp = a+b+carry;
                 if(temp>=10){
                      temp = temp%10;
                      carry = 1;
                 }else{ 
                     carry = 0;     //注意要将carry的值重新设置为0，否则值一直为1，
                  }
                 ListNode t = new ListNode(temp);
                 t.next = tail;
                 tail = t;
           }
           if(carry==1){
                 ListNode t = new ListNode(1);
                 t.next = tail;
                 tail = t;
           }
           return tail;
    }
}
