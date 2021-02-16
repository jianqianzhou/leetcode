class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          List<List<String>> res = new ArrayList<>();
          Map<String,List> map = new HashMap<>();  //这里是卡壳的地方，想到了怎么存，但是没有想到具体的数据结构，使用map，map的key为string，value为list的结构
          for(int i=0; i<strs.length; i++){       //map中存放的结构为(aet,<eat,tea,ate>)
              char[] chs = strs[i].toCharArray();
              Arrays.sort(chs);
              String str = new String(chs);
              if(map.containsKey(str)){
                  List<String> temp = map.get(str);
                  temp.add(strs[i]);
                  map.put(str,temp);
              }else{
                  List<String> list = new ArrayList<>();
                  list.add(strs[i]);
                  map.put(str, list);
              }
          }
          for(List<String> t: map.values()){
               res.add(t);
          }
          return res;
    }

   /////优化写法
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }

   /////////不使用排序的写法，因为异位的字符串包含的个数是相同的
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            int[] count = new int[26];
            char[] chs = s.toCharArray();
            for(char ch:chs){
                count[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                if(count[i]!=0){
                   sb.append(count[i]+"");
                   sb.append(i-'a'+"");
                }
            }
            String key = sb.toString();
            List<String> list = map.getOrDefault(key,new ArrayList<String>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
   }
}
