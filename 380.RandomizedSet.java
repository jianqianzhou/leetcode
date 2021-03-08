////////////通过率8.3%
//要求插入、删除和随机获取元素都是o(1)的，以下插入和删除都是O(1)，但是随机获取元素是o(n)的
class RandomizedSet {

     private LinkedList list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new LinkedList();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
           if(list.contains(val)) return false;
           return list.add(val);   
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
       return list.remove((Integer)val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int size = list.size();
        return (int)list.get(random.nextInt(size));
    }
}

////////
//哈希表提供常数时间的插入和删除，getRandom是o(n)级别的
//动态数组存储元素值，哈希表存储值到索引的映射  哈希表+动态数组
class RandomizedSet{
    private Map<Integer, Integer> map;
    private List<Integer> list;
    Random random = new Random();
    public RandomizedSet(){
         map = new HashMap<>();
         list = new ArrayList<>();
    }
    public boolean insert(int val){
         if(map.containsKey(val)) return false;
         map.put(val, list.size());      //刚开始写成了list.add(list.size(), val); map.put(val, list.size()); 错误原因：map在添加时list已经存在了元素值，导致出错,list.add(0, 1); map.put(1, 1);
         list.add(list.size(), val);
         return true;
    }
    public boolean remove(int val){
         if(map.containsKey(val)){   
              int last = list.get(list.size()-1);  //获取最后一个元素值
              int idx = map.get(val);    //获取当前需要删除元素的索引
              list.set(idx, last);    //将最后一个元素插入到删除元素的索引上
              map.put(last,idx);     //更新最后一个元素的索引值
              list.remove(list.size()-1);   //删除最后一个元素
              map.remove(val);  //删除当前需要删除的元素值
              return true;
         }
         return false;
    }
    public int getRandom(){
        return list.get(random.nextInt(list.size()));
    }
}
