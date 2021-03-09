class Solution {
       //时间复杂度为0{n}，空间复杂度为o(n)，通过率7%，将链表存放在数组中，然后比较
       public boolean isPalindrome(ListNode head) {
         ListNode p = head;
         int length = 0;
         while(p!=null){
             length++;
             p = p.next;
         }
         int[] nums = new int[length];
         p = head;
         int i=0;
         while(p!=null){
             nums[i++] = p.val;
             p = p.next;
         }
         int left = 0, right = length-1;
         while(left<=right){

             if(nums[left]!=nums[right]) return false;
             left++;
             right--;
         }
        return true;
    }
   
    ///////////////////////优化空间复杂,通过率为5%，将后半部分反转，然后比较
     public boolean isPalindrome(ListNode head){
           ListNode slow = head;
           ListNode fast = head;
           while(fast.next!=null && fast.next.next!=null){
                  slow = slow.next;
                  fast = fast.next.next;
           }
           ListNode t = reverse(slow.next);
           slow.next = null;
           while(head!=null && t!=null){
               if(head.val!=t.val) return false;
               head = head.next;
               t = t.next;
           }
           return true;
    }
    ListNode reverse(ListNode t){
        ListNode prev = null;
        while(t!=null){
            ListNode next = t.next;
            t.next = prev;
            prev = t;
             t = next;
        }
        return prev;
    }
    ///优化空间和时间复杂度
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {   //一边遍历，一边将前半部分反转
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) { //比较前半部分和后半部分
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }

}
