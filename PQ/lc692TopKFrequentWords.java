
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        //Time: O(nlog(k)) first go through n words then sort them in log(k) times in pq
        //Space: O(n)
        Map<String, Integer> map = new HashMap<>();
        
        for (String w: words) {
            map.put(w, map.getOrDefault(w,0)+1);
        }
        
        List<String> res = new ArrayList<>();
        // the key point for this approach is how to wirte the comparater, first sort by the value, then sort by key.
        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue() );
        for (String key: map.keySet()) {
            Pair<String, Integer> tmp = new Pair<>(key, map.get(key));
            // System.out.println(tmp);
            pq.add(tmp);
        }
        
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().getKey());
        }
        
       
        
        return res;
        
    }
}