class MyHashMap {
 class Node{  //新建一个数据结构
      int key;
      int value;
      Node next;
      public Node(int key, int value){
          this.key = key;
          this.value = value;
      }
    }

    private Node[] map;
    private int cap=10000;
    /** Initialize your data structure here. */
    public MyHashMap() {
         this.map = new Node[cap];
    }

    public int hash(int key){
        return key%cap;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
         int index = hash(key);
         if(map[index] == null){   //注意这里的写法  ，刚开始写成了Node t = map[index] if(t!=null) t=****  错误原因是值复制，并不是引用赋值
             map[index] = new Node(-1,-1); //所以这里赋值需要写成map[index]=***的格式
             Node node = new Node(key,value);
             map[index].next = node;
         }else{
             Node t = map[index];
             while(t.next!=null){  //注意是 t.next!=null,否则会出现t.next会出现空指针,因为节点为<-1,-1>-><2,2>，然后删除<2,2>，为<-1,-1>
               if(t.next.key==key){  //当t指向-1，如果写的是while(t!=null) 那么t=t.next后，t会指向下一个元素的节点，为空节点，后续插入节点就会报错
                  t.next.value = value;
                  return;
               }
               t = t.next;
             }  
             Node node = new Node(key,value);
             t.next = node; //这里会出现空指针
             node.next = null;
         }  
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
         int index = hash(key);
         Node t = map[index];
         while(t!=null){
             if(t.key==key){
                return t.value;
             }
             t = t.next;
         }
         return -1;
    }
 /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
         int index = hash(key);
         if(map[index]!=null){
            Node prev = map[index];  //前置节点
            Node t = prev.next;  //后置节点
            while(t!=null){
                if(t.key==key){
                    prev.next = t.next;
                }
                t = t.next;
                prev = prev.next;
            }
         }
    }
}

