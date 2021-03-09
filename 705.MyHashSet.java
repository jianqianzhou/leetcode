class MyHashSet {
     ////通过率5%
     //
     // [1-->2-->3-->4-->5-->6]
     //
     //
     //
    private LinkedList<Integer> set;
    /** Initialize your data structure here. */
    public MyHashSet() {
        set = new LinkedList<>();
    }

    public void add(int key) {
          if(set.contains(key)) return;
          else set.add(key);
    }

    public void remove(int key) {
          if(set.contains(key)){
             set.remove((Integer)key);
          }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
            return set.contains(key);
    }

}
   ////////////////优化设计，通过率33%，主要是使用了数组，缓存命中率之类的
   //
   //
   //  [1-->5-->9]
   //  [2-->6-->10]
   //  [3-->7-->11]
   //  [4-->8-->12]
   //
   //
class MyHashSet {
     private Bucket[] bucket;
     private int cap=769;   //值设置的越大，命中率越低
     public MyHashSet() {
          this.bucket = new Bucket[cap];
          for(int i=0; i<cap; i++){
               this.bucket[i] = new Bucket();  //这里将每一个数组值初始化
          }
     }
     public int hash(int key){
         return key%cap;
     }
     public void add(int key){
         Bucket bk = bucket[hash(key)];
         if(bk.list.contains(key)) return;
         else bk.list.add(key);
          
     }
     public void remove(int key){
          Bucket bk = bucket[ hash(key)];
          if(bk.list.contains(key)) 
               bk.list.remove( (Integer)key );
     }
     public boolean contains(int key){
          Bucket bk = bucket[hash(key)];
          return bk.list.contains(key);
     }
     class Bucket{
         private LinkedList<Integer> list;
         public Bucket(){
             this.list = new LinkedList<>();
         }
     }
}

/**
 *  * Your MyHashSet object will be instantiated and called as such:
 *   * MyHashSet obj = new MyHashSet();
 *    * obj.add(key);
 *     * obj.remove(key);
 *      * boolean param_3 = obj.contains(key);
 *       */
}
