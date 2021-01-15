class Solution {   //时间37%
    public ListNode mergeKLists(ListNode[] lists) {
          ListNode ans = null;
          for(int i=0; i<lists.length; i++){
                 ans = mergeTwoList(ans,lists[i]);  //两两合并
          }   
          return ans;
    }
    public ListNode mergeTwoList(ListNode a, ListNode b){
         ListNode dymm = new ListNode(-1);
         ListNode h = dymm;
         ListNode h1 = a;
         ListNode h2 = b;
         while(h1!=null && h2!=null){
              if(h1.val>h2.val){
                  h.next = h2;
                  h = h.next;
                  h2 = h2.next;
              }else{
                  h.next = h1;
                  h = h.next;
                  h1 = h1.next;
              }
         }
         if(h1!=null) h.next = h1;
         else h.next = h2;
         return dymm.next;
    }

//////////////////////////////////分治合并,时间100%
class Solution {
     public ListNode mergeKLists(ListNode[] lists) {
           return merge(lists,0,lists.length-1);
     }
     public ListNode merge(ListNode[] lists,int l, int r){
           int mid = (l+r)/2;
           if(l==r){
               return lists[l];
           }
           if(l>r) return null;
           return mergeTwoList(merge(lists,l,mid),merge(lists,mid+1,r));
     }
      public ListNode mergeTwoList(ListNode a, ListNode b){
         ListNode dymm = new ListNode(-1);
         ListNode h = dymm;
         ListNode h1 = a;
         ListNode h2 = b;
         while(h1!=null && h2!=null){
              if(h1.val>h2.val){
                  h.next = h2;
                  h = h.next;
                  h2 = h2.next;
              }else{
                  h.next = h1;
                  h = h.next;
                  h1 = h1.next;
              }
         }
         if(h1!=null) h.next = h1;
         else h.next = h2;
         return dymm.next;
    }
}
