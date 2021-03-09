class LRUCache {
    //
    //   ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    //   [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    //   输出
    //   [null, null, null, 1, null, -1, null, -1, 3, 4]
    //
    //    <1,1>--><2,2>
    //    <2,2>--><1,1>
    //
    private LinkedHashMap<Integer,Integer> queue;
    private int cap;
    public LRUCache(int capacity) {
        queue = new LinkedHashMap<>();
        this.cap = capacity;
    }    
    
    public int get(int key) {
         if(queue.containsKey(key)){  //如果缓存中包含key，那么需要将key移动到队列头部，表示最近访问了
            int value = queue.get(key);  
            queue.remove(key);  //移除这个节点
            queue.put(key,value);  //重新插入到队头
            return value;
         }
         else return -1;

    }

   public void put(int key, int value) {
        if(queue.containsKey(key)){   //这里不能先判断大小，因为当大小为2，集合中有[1,2],[2,6]时，当加入的值为[1,5]时，大小不会溢出，但是如果先判断大小的话，会导致结果溢出，从而删除操作
           queue.remove(key);
        }else{
          if(queue.size()==this.cap){   //如果原始的队列大小等于容量大小了
              int last = queue.keySet().iterator().next();  //需要删除尾结点
              queue.remove(last);
           }
        }
        queue.put(key,value);  //将元素插入到队列中
    }
}
